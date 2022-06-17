package others;

import gs.common.other_funcs;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;

public class custom_image_funcs {

  public static void drawFixedOverSpeedIcon(OutputStream output, String format_type_, int radius_, int speed_) throws IOException {
    // Create the graphics
    Graphics2D graphics = null;
    try {
      // Create the image
      BufferedImage image = new BufferedImage(radius_ * 2 + 1, radius_ * 2 + 1, BufferedImage.TYPE_INT_ARGB);
      graphics = image.createGraphics();
      // Set rendering hints
      graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT);
      graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

      if (format_type_.equals("png")) {
        //clear
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
        graphics.fillRect(0, 0, 256, 256);

        //reset composite
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
      }

      // Set the color
      Color new_color_ = Color.decode("#FF0000");
      graphics.setColor(new_color_);

      int x = radius_;
      int y = radius_;
      graphics.fillOval(x - radius_, y - radius_, radius_ * 2 + 1, radius_ * 2 + 1);

      new_color_ = Color.decode("#FFFFFF");
      graphics.setColor(new_color_);
      int new_radius_ = radius_ - other_funcs.roundToIntV2(radius_ * 0.2);
      graphics.fillOval(x - new_radius_, y - new_radius_, new_radius_ * 2 + 1, new_radius_ * 2 + 1);

      new_color_ = Color.decode("#000000");
      graphics.setColor(new_color_);
      int font_size_ = other_funcs.roundToInt(radius_ / 160.0 * 170.0);
      Font font_ = new Font("SansSerif", Font.BOLD, font_size_);
      //Font new_font_ = scaleFontToFit(String.valueOf(speed_), radius_ * 2, graphics, font_);
      graphics.setFont(font_);
      //graphics.drawString(String.valueOf(speed_), radius_, radius_);
      //Dimension d = this.getSize();
      //Rectangle rect_ = new Rectangle(130, 130, 20, 20);
      drawCenteredString(String.valueOf(speed_), radius_ * 2 + 1, radius_ * 2 + 1, graphics);
      //drawCenteredString(graphics, String.valueOf(speed_), rect_, font_);
      //int stroke_width_ = other_funcs.roundToInt(radius_ / 10.0 * 2.0);
      //graphics.setStroke(new BasicStroke(stroke_width_));
      //graphics.drawLine(radius_, radius_, radius_ * 2 - other_funcs.roundToIntV2(radius_ * 0.35), radius_);

      // Write the rescaled image
      ImageIO.write(image, format_type_, output);
    } finally {
      // Always dispose the graphics
      graphics.dispose();
    }
  }

  public static Font scaleFontToFit(String text, int width, Graphics g, Font pFont) {
    float fontSize = pFont.getSize();
    float fWidth = g.getFontMetrics(pFont).stringWidth(text);
    if (fWidth <= width) {
      return pFont;
    }
    fontSize = ((float) width / fWidth) * fontSize;
    return pFont.deriveFont(fontSize);
  }

  public Font scaleFont(String text, Rectangle rect, Graphics g, Font pFont) {
    float fontSize = 20.0f;
    Font font = pFont;

    font = g.getFont().deriveFont(fontSize);
    int width = g.getFontMetrics(font).stringWidth(text);
    fontSize = (rect.width / width) * fontSize;
    return g.getFont().deriveFont(fontSize);
  }

  public static Font scaleFontV2(String text, Rectangle rect, Graphics g, Font pFont) {
    float min = 0.1f;
    float max = 72f;
    float size = 18.0f;
    Font font = pFont;

    while (max - min <= 0.1) {
      font = g.getFont().deriveFont(size);
      FontMetrics fm = g.getFontMetrics(font);
      int width = fm.stringWidth(text);
      if (width == rect.width) {
        return font;
      } else {
        if (width < rect.width) {
          min = size;
        } else {
          max = size;
        }
        size = Math.min(max, Math.max(min, size * (float) rect.width / (float) width));
      }
    }
    return font;
  }

  private Font scaleFont(String text, Rectangle rect, Graphics gc) {
    final float fMinimumFont = 0.1f;
    float fMaximumFont = 1000f;

    /* Use Point2d.Float to hold ( font, width of font in pixels ) pairs. */
    Point2D.Float lowerPoint = new Point2D.Float(fMinimumFont, getWidthInPixelsOfString(text, fMinimumFont, gc));
    Point2D.Float upperPoint = new Point2D.Float(fMaximumFont, getWidthInPixelsOfString(text, fMaximumFont, gc));
    Point2D.Float midPoint = new Point2D.Float();

    for (int i = 0; i < 50; i++) {
      float middleFont = (lowerPoint.x + upperPoint.x) / 2;

      midPoint.setLocation(middleFont, getWidthInPixelsOfString(text, middleFont, gc));

      if (midPoint.y >= rect.getWidth() * .95 && midPoint.y <= rect.getWidth()) {
        break;
      } else if (midPoint.y < rect.getWidth()) {
        lowerPoint.setLocation(midPoint);
      } else if (midPoint.y > rect.getWidth()) {
        upperPoint.setLocation(midPoint);
      }
    }

    fMaximumFont = midPoint.x;

    Font font = gc.getFont().deriveFont(fMaximumFont);

    /* Now use Point2d.Float to hold ( font, height of font in pixels ) pairs. */
    lowerPoint.setLocation(fMinimumFont, getHeightInPixelsOfString(text, fMinimumFont, gc));
    upperPoint.setLocation(fMaximumFont, getHeightInPixelsOfString(text, fMaximumFont, gc));

    if (upperPoint.y < rect.getHeight()) {
      return font;
    }

    for (int i = 0; i < 50; i++) {
      float middleFont = (lowerPoint.x + upperPoint.x) / 2;

      midPoint.setLocation(middleFont, getHeightInPixelsOfString(text, middleFont, gc));

      if (midPoint.y >= rect.getHeight() * .95 && midPoint.y <= rect.getHeight()) {
        break;
      } else if (midPoint.y < rect.getHeight()) {
        lowerPoint.setLocation(midPoint);
      } else if (midPoint.y > rect.getHeight()) {
        upperPoint.setLocation(midPoint);
      }
    }

    fMaximumFont = midPoint.x;

    font = gc.getFont().deriveFont(fMaximumFont);

    return font;
  }

  private float getWidthInPixelsOfString(String str, float fontSize, Graphics gc) {
    Font font = gc.getFont().deriveFont(fontSize);

    return getWidthInPixelsOfString(str, font, gc);
  }

  private float getWidthInPixelsOfString(String str, Font font, Graphics gc) {
    FontMetrics fm = gc.getFontMetrics(font);
    int nWidthInPixelsOfCurrentFont = fm.stringWidth(str);

    return (float) nWidthInPixelsOfCurrentFont;
  }

  private float getHeightInPixelsOfString(String string, float fontSize, Graphics gc) {
    Font font = gc.getFont().deriveFont(fontSize);

    return getHeightInPixelsOfString(string, font, gc);
  }

  private float getHeightInPixelsOfString(String string, Font font, Graphics gc) {
    FontMetrics metrics = gc.getFontMetrics(font);
    int nHeightInPixelsOfCurrentFont = (int) metrics.getStringBounds(string, gc).getHeight() - metrics.getDescent() - metrics.getLeading();

    return (float) nHeightInPixelsOfCurrentFont * .75f;
  }

  public static void drawCenteredString(String s, int w, int h, Graphics g) {
    FontMetrics fm = g.getFontMetrics();
    int x = other_funcs.roundToIntV2((w - fm.stringWidth(s)) / 2.0);
    int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
    g.drawString(s, x, y);
  }

  /**
   Draw a String centered in the middle of a Rectangle.
   @param g The Graphics instance.
   @param text The String to draw.
   @param rect The Rectangle to center the text in.
   */
  public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
    // Get the FontMetrics
    FontMetrics metrics = g.getFontMetrics(font);
    // Determine the X coordinate for the text
    int x = (rect.width - metrics.stringWidth(text)) / 2;
    // Determine the Y coordinate for the text
    int y = ((rect.height - metrics.getHeight()) / 2) - metrics.getAscent();
    // Set the font
    g.setFont(font);
    // Draw the String
    g.drawString(text, x, y);
    // Dispose the Graphics
    //g.dispose();
  }

  /**
   This method centers a <code>String</code> in
   a bounding <code>Rectangle</code>.
   @param g - The <code>Graphics</code> instance.
   @param r - The bounding <code>Rectangle</code>.
   @param s - The <code>String</code> to center in the
   bounding rectangle.
   @param font - The display font of the <code>String</code>
   @see java.awt.Graphics
   @see java.awt.Rectangle
   @see java.lang.String
   */
  public static void drawCenteredStringV2(Graphics g, String s, Rectangle r, Font font) {
    FontRenderContext frc
      = new FontRenderContext(null, true, true);

    Rectangle2D r2D = font.getStringBounds(s, frc);
    int rWidth = (int) Math.round(r2D.getWidth());
    int rHeight = (int) Math.round(r2D.getHeight());
    int rX = (int) Math.round(r2D.getX());
    int rY = (int) Math.round(r2D.getY());

    int a = (r.width / 2) - (rWidth / 2) - rX;
    int b = (r.height / 2) - (rHeight / 2) - rY;

    g.setFont(font);
    g.drawString(s, r.x + a, r.y + b);
  }
}
