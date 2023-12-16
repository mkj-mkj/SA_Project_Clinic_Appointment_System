package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class Doctor
 * Doctor類別（class）具有醫生所需要之屬性與方法，並且儲存與醫生相關之商業判斷邏輯
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class Doctor {

    private String Id;

    private String Name;

    private int DepId;

    private Department department;

    /** deph，DepartmentHelper之物件與Department相關之資料庫方法（Sigleton） */
    private DepartmentHelper deph = DepartmentHelper.getHelper();

    /** dh，DoctorHelper之物件與Doctor相關之資料庫方法（Sigleton） */
    private DoctorHelper dh = DoctorHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）Doctor物件<br>
     */
    public Doctor(int Id) {

    }

    /**
     * 實例化（Instantiates）一個新的（new）Doctor物件<br>
     */
    public Doctor(int Id, String Name) {

    }

    /**
     * 實例化（Instantiates）一個新的（new）Doctor物件<br>
     */
    public Doctor(int Id, String Name, int DepId) {

    }

    /**
     * 取得醫生之編號
     *
     * @return the id 回傳醫生編號
     */
    public String getID() {
        return this.Id;
    }

    public String getName() {

    }

    public int getDepartment() {

    }

    /**
     * 取得該醫生所有資料
     *
     * @return the data 取得該名醫生之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {

    }

}