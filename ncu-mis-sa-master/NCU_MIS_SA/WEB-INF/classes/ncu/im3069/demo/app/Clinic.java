package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

/**
 * The Class Clinic
 * Clinic類別（class）具有門診所需要之屬性與方法，並且儲存與門診相關之商業判斷邏輯
 */

public class Clinic {

    private int Id;

    private String Name;

    private int DeptId;

    private Department department;

    /** deph，DepartmentHelper之物件與Department相關之資料庫方法（Sigleton） */
    private DepartmentHelper deph = DepartmentHelper.getHelper();

    /** ch，ClinicHelper之物件與Clinc相關之資料庫方法（Sigleton） */
    private ClinicHelper ch = ClinicHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）Clinic物件
     */
    public Clinic() {

    }

    /**
     * 實例化（Instantiates）一個新的（new）Clinic物件
     */
    public Clinic(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Clinic物件
     */
    public Clinic(int Id, String Name, int DeptId) {
        this.Id = Id;
        this.Name = Name;
        this.DeptId = DeptId;
    }

    /**
     * 取得門診編號
     * 
     * @return the id 回傳門診編號
     */
    public int getID() {
        return this.Id;
    }

    /**
     * 取得門診名稱
     * 
     * @return the id 回傳門診名稱
     */
    public String getName() {
        return this.Name;
    }

    /**
     * 取得門診所屬的科別編號
     * 
     * @return the id 回傳科別編號
     */
    public int getDeptID() {
        return this.DeptId;
    }

    /**
     * 更新門診資料
     * 
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {
        /** 新建一個JSONObject用以儲存更新後之資料 */
        JSONObject data = new JSONObject();

        /** 檢查該門診是否已經在資料庫 */
        if (this.Id != 0) {
            /** 透過ClinicHelper物件，更新目前之門診資料置資料庫中 */
            data = ch.update(this);
        }
        return data;
    }

    /**
     * 取得該門診所有資料
     * 
     * @return the data 取得該門診所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該門診所需之資料全部進行封裝 */
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("name", getName());
        jso.put("dpet_id", getDeptID());
        return jso;
    }

    /**
     * 計算新門診編號
     */
    /**
     * private void setID(JSONArray data) {
     * for(int i=0 ; i < this.list.size() ; i++) {
     * this.list.get(i).setId((int) data.getLong(i));
     * }
     * }
     **/
}
