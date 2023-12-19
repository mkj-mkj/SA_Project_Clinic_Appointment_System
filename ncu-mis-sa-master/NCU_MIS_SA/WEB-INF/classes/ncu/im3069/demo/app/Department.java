package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

/**
 * The Class Department
 * Department類別（class）具有科別所需要之屬性與方法，並且儲存與科別相關之商業判斷邏輯
 */

public class Department {

    private int Id;

    private String Name;

    /** deph，DepartmentHelper之物件與Deoartnebt相關之資料庫方法（Sigleton） */
    private DepartmentHelper deph = DepartmentHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）Department物件<br>
     */
    public Department(int Id) {
        this.Id = Id;
    }

    /**
     * 實例化（Instantiates）一個新的（new）Department物件<br>
     */
    public Department(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    /**
     * 取得科別之編號
     * 
     * @return the id 回傳科別編號
     */
    public int getID() {
        return this.Id;
    }

    /**
     * 取得科別之名稱
     * 
     * @return the id 回傳科別名稱
     */
    public String getName() {
        return this.Name;
    }

    /**
     * 取得該科別所有資料
     * 
     * @return the data 取得該名科別之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該名科別所需之資料全部進行封裝 */
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("name", getName());
        return jso;
    }

}