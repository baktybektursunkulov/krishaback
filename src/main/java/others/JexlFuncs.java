package others;

import gs.common.MyException;
import gs.common.byte_funcs;
import gs.common.dm.cs_funcs;
import gs.common.hex_funcs;
import gs.common.string_funcs;
import java.nio.ByteOrder;
import org.apache.commons.jexl.Expression;
import org.apache.commons.jexl.ExpressionFactory;
import org.apache.commons.jexl.JexlContext;
import org.apache.commons.jexl.JexlHelper;

public class JexlFuncs {

  public static Object getCalculatedValue(String expression_str_, JexlContext jexl_context_) throws Exception {
    Object res = null;
    Expression expression_ = null;
    expression_ = ExpressionFactory.createExpression(expression_str_);
    jexl_context_.getVars().put("Math", Math.class);
    jexl_context_.getVars().put("String", String.class);
    jexl_context_.getVars().put("Double", Double.class);
    jexl_context_.getVars().put("Integer", Integer.class);
    jexl_context_.getVars().put("Short", Short.class);
    jexl_context_.getVars().put("Long", Long.class);
    jexl_context_.getVars().put("byte_funcs", byte_funcs.class);
    jexl_context_.getVars().put("ByteOrder", ByteOrder.class);
    jexl_context_.getVars().put("hex_funcs", hex_funcs.class);
    jexl_context_.getVars().put("cs_funcs", cs_funcs.class);
    jexl_context_.getVars().put("string_funcs", string_funcs.class);
    res = expression_.evaluate(jexl_context_);
    return res;
  }

  public static void main(String[] params) throws Exception {
    //addFilePath("H:\\Program Files\\apache-tomcat-7.0.19-core-v3\\lib");
    //addFilePath("H:\\Program Files\\apache-tomcat-7.0.19-core-v3\\lib\\additional");

    /*
    JexlContext jexl_context_ = JexlHelper.createContext();
    jexl_context_.getVars().put("G1", "12");
    jexl_context_.getVars().put("G2", 2);
    jexl_context_.getVars().put("G3", 3);
    jexl_context_.getVars().put("G4", 4);
    jexl_context_.getVars().put("angle", 30);
    jexl_context_.getVars().put("str1", "9521");
    Object obj_ = JexlFuncs.getCalculatedValue("((G1 + G2 + G3) * 0.1) + G4", jexl_context_);
    Double result = (Double) obj_;
    System.out.println("result=" + result);

    System.out.println("obj_=" + JexlFuncs.getCalculatedValue("str1.charAt(0)", jexl_context_));
    System.out.println("obj_=" + JexlFuncs.getCalculatedValue("str1.charAt(1)", jexl_context_));
    System.out.println("obj_=" + JexlFuncs.getCalculatedValue("Math.cos(30)", jexl_context_));
    System.out.println("obj_=" + JexlFuncs.getCalculatedValue("String.valueOf(G4)", jexl_context_));
    System.out.println("obj_=" + JexlFuncs.getCalculatedValue("Double.valueOf(str1)", jexl_context_));
    System.out.println("obj_=" + JexlFuncs.getCalculatedValue("Integer.valueOf(str1)", jexl_context_));
     */
    /*
    String str_ = "{hex_funcs.le_long_to_hex(Long.valueOf(\"%UID%\"))}010008{cs_funcs.bce_hex_cs(hex_funcs.le_long_to_hex(Long.valueOf(\"%UID%\")) + \"010008\")}";
    str_ = str_.replace("%UID%", "868324023582013");
    //dm_checksum_funcs.bce_get_checksum()
    //String str_ = "dm_checksum_funcs.bce_get_checksum(hex_funcs.byteArrToHex(byte_funcs.convertLongTo8ByteArray(Long.valueOf(\"%UID%\"), ByteOrder.BIG_ENDIAN)))";
    String tmp_str_ = str_;
    int start_idx_, end_idx_;
    String formula_, formula_calc_val_;
    JexlContext jexl_context_ = JexlHelper.createContext();
    while (tmp_str_.contains("{")) {
      start_idx_ = tmp_str_.indexOf("{");
      if (start_idx_ == -1) {
        throw new MyException("Incorrect formula=" + str_);
      }
      end_idx_ = tmp_str_.indexOf("}");
      if (end_idx_ == -1) {
        throw new MyException("Incorrect formula=" + str_);
      }
      formula_ = tmp_str_.substring(start_idx_ + 1, end_idx_);
      formula_calc_val_ = (String) JexlFuncs.getCalculatedValue(formula_, jexl_context_);
      tmp_str_ = tmp_str_.substring(0, start_idx_) + formula_calc_val_ + tmp_str_.substring(end_idx_ + 1);
    }
    System.out.println(tmp_str_);

    str_ = "cs_funcs.bce_hex_cs(hex_funcs.le_long_to_hex(Long.valueOf(\"234\")))";
    //jexl_context_.getVars().put("G1", 868324023582013);
    JexlContext jexl_context1_ = JexlHelper.createContext();
    Object obj_ = JexlFuncs.getCalculatedValue(str_, jexl_context1_);
    System.out.println(obj_);

    str_ = "hex_funcs.byteToHex(112)";
    JexlContext jexl_context2_ = JexlHelper.createContext();
    Object obj2_ = JexlFuncs.getCalculatedValue(str_, jexl_context2_);
    System.out.println(obj2_);

    str_ = "String.valueOf('ST600R').replace('R', '')";
    //str_ = "new String('s dfsdf')";
    //str_ = str_.replace("DEVICE_MODEL_LAST_WORD", "ST600R");
    //jexl_context_.getVars().put("DEVICE_MODEL_LAST_WORD", "Test");
    JexlContext jexl_context3_ = JexlHelper.createContext();
    Object obj3_ = JexlFuncs.getCalculatedValue(str_, jexl_context3_);
    System.out.println(obj3_);
    new String("ds");
    //String.
*/
    String str_ = "hex_funcs.byteArrToHex(byte_funcs.shortToByteArray(Math.round(hex_funcs.str_to_hex(payload).length()/2) + 2))";
    byte[] byte_arr_;
    JexlContext jexl_context5_ = JexlHelper.createContext();
    jexl_context5_.getVars().put("payload", "imei");
    Object obj5_ = JexlFuncs.getCalculatedValue(str_, jexl_context5_);
    System.out.println(obj5_);

  }

}
