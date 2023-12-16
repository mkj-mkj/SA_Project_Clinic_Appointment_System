package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class Department
 * Department類別（class）具有科別所需要之屬性與方法，並且儲存與科別相關之商業判斷邏輯
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class Department {

    private String Id;

    private String Name;

    /** deph，DepartmentHelper之物件與Deoartnebt相關之資料庫方法（Sigleton） */
    private DepartmentHelper deph = DepartmentHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）Department物件<br>
     */
    public Department(int Id) {

    }

    /**
     * 實例化（Instantiates）一個新的（new）Department物件<br>
     */
    public Department(int Id, String Name) {

    }

    /**
     * 取得科別之編號
     *
     * @return the id 回傳科別編號
     */
    public String getID() {
        return this.Id;
    }

    public String getName() {

    }

    /**
     * 取得該科別所有資料
     *
     * @return the data 取得該名科別之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {

    }

}