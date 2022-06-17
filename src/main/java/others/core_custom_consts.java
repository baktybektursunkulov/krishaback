package others;


public class core_custom_consts {
   public static final String hierarchical_c_loc_sql_ = "WITH RECURSIVE t3 AS (\n"
    + "  SELECT t1.c_loc FROM c_loc t1 WHERE t1.c_loc = :c_loc_id_ and t1.is_deleted=false \n"
    + "  UNION ALL \n"
    + "  SELECT t2.c_loc FROM c_loc t2 JOIN t3 ON t2.parent_id = t3.c_loc and t2.is_deleted=false \n"
    + ")\n"
    + "SELECT t3.c_loc from t3 ";  
  
}
