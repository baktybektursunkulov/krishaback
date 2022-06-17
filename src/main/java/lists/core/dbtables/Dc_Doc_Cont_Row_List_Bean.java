package lists.core.dbtables;

import filters.core.dbtables.*;
import model.core.dbtables.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.LazyDataModel;
import gs.common.jsf.jsf_funcs;
import java.util.ArrayList;
import java.util.List;
import managers.core.dbtables.Dc_Doc_Cont_Row_Manager;
import org.hibernate.Session;import gs.common.hibernate_funcs;
import org.hibernate.Transaction;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import others.CustomLogger;
import virtualentities.Doc;
import virtualentities.Doc_Search_Content;
import virtualentities.Doc_Search_Title;

@ManagedBean
@SessionScoped
public class Dc_Doc_Cont_Row_List_Bean extends Abstract_List_Bean<Dc_Doc_Cont_Row> {
  
  TreeNode root;
  
  public static Dc_Doc_Cont_Row_List_Bean getCurrentBean() {
    return jsf_funcs.findBean("dc_Doc_Cont_Row_List_Bean");
  }
  
  public TreeNode getRoot() {
    if (root == null) {
      refresh_root();
    }
    return root;
  }
  
  public void setRoot(TreeNode root) {
    this.root = root;
  }
  
  public Dc_Doc_Cont_Row_List_Bean() {
    super("Dc_Doc_Cont_Row", (Dc_Doc_Cont_Row_Filter_Bean) jsf_funcs.findBean("dc_Doc_Cont_Row_Filter_Bean"));
  }
  
  public LazyDataModel<Dc_Doc_Cont_Row> getConverted_rec_list() {
    return getRec_list();
  }
  
  public List<Dc_Doc_Cont_Row> getConverted_rec_array_list() {
    return getRec_array_list();
  } 
  
  public Dc_Doc_Cont_Row_Filter_Bean getFilter_bean_wrapped() {
    return (Dc_Doc_Cont_Row_Filter_Bean) getFilter_bean();
  }
  
  public void refresh_root() {
    root = new DefaultTreeNode(new Doc("", ""), null);
    Transaction tx_ = null;
    Session session_ = model.core.dbutil.CoreSessionFactoryUtil.getSessionFactoryUtilInstance().openSession();
    try {
      tx_ = session_.beginTransaction();
      Integer dc_doc_cnt_id_ = null;
      if (getFilter_bean_wrapped().getFilter_entity().getDc_doc_cont() != null) {
        dc_doc_cnt_id_ = getFilter_bean_wrapped().getFilter_entity().getDc_doc_cont();
      }
      Integer parent_id_ = null;
      if (getFilter_bean_wrapped().getFilter_entity().getParent_id() != null) {
        parent_id_ = getFilter_bean_wrapped().getFilter_entity().getParent_id_t().getDc_doc_cont_row();
      }
      
      createNode(session_, root, dc_doc_cnt_id_, parent_id_, getFilter_bean_wrapped().getFilter_entity().getContent_txt());
      hibernate_funcs.commitAndClose(session_);
    } catch (Exception e) {
      CustomLogger.error(e);
      if (tx_ != null) {
        hibernate_funcs.rollbackAndClose(session_);
      }
      throw e;
    }
    expandNode(root);
  }
  
  public void createNode(Session session_, TreeNode root_, Integer dc_doc_cont_id_, Integer parent_id_, String content_txt_) {
    List<Dc_Doc_Cont_Row> dc_doc_cont_row_list_ = Dc_Doc_Cont_Row_Manager.getCI().get_dc_doc_cont_row_list(session_, dc_doc_cont_id_, parent_id_, false);
    Dc_Doc_Cont_Row dc_doc_cont_row_;
    TreeNode treeNode;
    for (int i = 0; i < dc_doc_cont_row_list_.size(); i++) {
      dc_doc_cont_row_ = dc_doc_cont_row_list_.get(i);
      if (content_txt_ != null && !content_txt_.trim().isEmpty()) {
        if (dc_doc_cont_row_.getContent_txt().toLowerCase().contains(content_txt_.trim().toLowerCase())) {
          dc_doc_cont_row_.setIs_content_txt_match(true);
        }
      }
      treeNode = new DefaultTreeNode(dc_doc_cont_row_, root_);
      
      createNode(session_, treeNode, dc_doc_cont_id_, dc_doc_cont_row_.getDc_doc_cont_row(), content_txt_);
    }
  }
  
  public void expandNode(TreeNode treeNode) {
    treeNode.setExpanded(true);
    for (int i = 0; i < treeNode.getChildren().size(); i++) {
      expandNode(treeNode.getChildren().get(i));
    }
  }
  
  public void move_up(Dc_Doc_Cont_Row rec_) {
    Dc_Doc_Cont_Row prev_rec_ = Dc_Doc_Cont_Row_Manager.getCI().get_prev_rec_by_parent_id(rec_);
    if (prev_rec_ != null) {
      rec_ = Dc_Doc_Cont_Row_Manager.getCI().get_rec_2(rec_.getDc_doc_cont_row());
      int prev_rec_order_num_ = prev_rec_.getOrder_num();
      int rec_order_num_ = rec_.getOrder_num();
      prev_rec_.setOrder_num(1000000);
      Dc_Doc_Cont_Row_Manager.getCI().merge_rec(prev_rec_);
      rec_.setOrder_num(prev_rec_order_num_);
      Dc_Doc_Cont_Row_Manager.getCI().merge_rec(rec_);
      prev_rec_.setOrder_num(rec_order_num_);
      Dc_Doc_Cont_Row_Manager.getCI().merge_rec(prev_rec_);
    }
    refresh_root();
  }
  
  public void del(Dc_Doc_Cont_Row rec_) {
    Dc_Doc_Cont_Row_Manager.getCI().delete_rec_2(rec_.getDc_doc_cont_row());
    refresh_root();
  }
  
  public void move_down(Dc_Doc_Cont_Row rec_) {
    Dc_Doc_Cont_Row next_rec_ = Dc_Doc_Cont_Row_Manager.getCI().get_next_rec_by_parent_id(rec_);
    if (next_rec_ != null) {
      rec_ = Dc_Doc_Cont_Row_Manager.getCI().get_rec_2(rec_.getDc_doc_cont_row());
      int next_rec_order_num_ = next_rec_.getOrder_num();
      int rec_order_num_ = rec_.getOrder_num();
      next_rec_.setOrder_num(1000000);
      Dc_Doc_Cont_Row_Manager.getCI().merge_rec(next_rec_);
      rec_.setOrder_num(next_rec_order_num_);
      Dc_Doc_Cont_Row_Manager.getCI().merge_rec(rec_);
      next_rec_.setOrder_num(rec_order_num_);
      Dc_Doc_Cont_Row_Manager.getCI().merge_rec(next_rec_);
    }
    refresh_root();
  }
  
}
