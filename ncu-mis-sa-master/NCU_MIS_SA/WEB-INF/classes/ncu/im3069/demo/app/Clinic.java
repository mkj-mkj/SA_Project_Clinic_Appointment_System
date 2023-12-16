package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
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

    }

    /**
     * 實例化（Instantiates）一個新的（new）Clinic物件
     */
    public Clinic(int Id, String Name, int DeptId) {

    }

    /**
     * 取得門診編號
     *
     * @return the id 回傳門診編號
     */
    public int getID() {
        return this.Id;
    }

    public String getName() {

    }

    public String getDeptID() {

    }

    /**
     * 更新門診資料
     * 
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {

    }

    /**
     * 取得該門診所有資料
     * 
     * @return the data 取得該門診所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {

    }

    /**
     * 計算新門診編號<br>
     */
    private void setID() {

    }
}
