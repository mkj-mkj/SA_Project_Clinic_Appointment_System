package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

/**
 * The Class Doctor
 * Doctor類別（class）具有醫生所需要之屬性與方法，並且儲存與醫生相關之商業判斷邏輯
 */

public class Doctor {

    private int Id;

    private String Name;

    private int DeptId;

    private Department department;

    /** deph，DepartmentHelper之物件與Department相關之資料庫方法（Sigleton） */
    private DepartmentHelper deph = DepartmentHelper.getHelper();

    /** dh，DoctorHelper之物件與Doctor相關之資料庫方法（Sigleton） */
    private DoctorHelper dh = DoctorHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）Doctor物件
     */
    public Doctor(int Id) {
        this.Id = Id;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Doctor物件
     */
    public Doctor(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Doctor物件
     */
    public Doctor(int Id, String Name, int DeptId) {
        this.Id = Id;
        this.Name = Name;
        this.DeptId = DeptId;
    }

    /**
     * 取得醫生之編號
     *
     * @return the id 回傳醫生編號
     */
    public int getID() {
        return this.Id;
    }

    /**
     * 取得醫生姓名
     * 
     * @return the id 回傳醫生姓名
     */
    public String getName() {
        return this.Name;
    }

    /**
     * 取得醫生所屬之科別編號
     * 
     * @return the id 回傳科別編號
     */
    public int getDepartment() {
        return this.DeptId;
    }

    /**
     * 取得該醫生所有資料
     *
     * @return the data 取得該名醫生之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該醫生所需之資料全部進行封裝 */
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("name", getName());
        jso.put("dept_id", getDepartment());
        return jso;
    }

}