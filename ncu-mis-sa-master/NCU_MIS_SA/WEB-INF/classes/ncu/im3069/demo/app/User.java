package ncu.im3069.demo.app;

import org.json.*;

import java.security.Timestamp;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Class User
 * User類別（class）具有使用者所需要之屬性與方法，並且儲存與使用者相關之商業判斷邏輯
 */

public class User {

    private String Id;

    private String Name;

    private int CaseNumber;

    private String Address;

    private Timestamp Birth;

    private Boolean Gender;

    private String Email;

    private String Phone;

    private String ResidenceTel;

    private String BloodType;

    private float Height;

    private float Weight;

    private String AllergyHistory;

    private String ServillHistory;

    private String ContactName;

    private String ContactRel;

    private String ContactTel;

    /** uh，UserHelper之物件與User相關之資料庫方法（Sigleton） */
    private UserHelper uh = UserHelper.getHelper();

    /**
     * 實例化（Instantiates）一個新的（new）User物件
     */
    public User(String Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    /**
     * 實例化（Instantiates）一個新的（new）User物件<br>
     */
    public User(String Id, String Name, int CaseNumber) {
        this.Id = Id;
        this.Name = Name;
        this.CaseNumber = CaseNumber;
    }

    /**
     * 實例化（Instantiates）一個新的（new）User物件<br>
     */
    public User(String Id, String Name, int CaseNumber, String Address, Timestamp Birth, Boolean Gender, String Email,
            String Phone, String ResidenceTel, String BloodType, float Height, float Weight, String AllergyHistory,
            String ServillHistory, String ContactName, String ContactRel, String ContactTel) {
        this.Id = Id;
        this.Name = Name;
        this.CaseNumber = CaseNumber;
        this.Address = Address;
        this.Birth = Birth;
        this.Email = Email;
        this.Gender = Gender;
        this.Phone = Phone;
        this.ResidenceTel = ResidenceTel;
        this.BloodType = BloodType;
        this.Height = Height;
        this.Weight = Weight;
        this.AllergyHistory = AllergyHistory;
        this.ServillHistory = ServillHistory;
        this.ContactName = ContactName;
        this.ContactRel = ContactRel;
        this.ContactTel = ContactTel;
    }

    /**
     * 取得使用者之身分證字號
     *
     * @return the id 回傳身分證字號
     */
    public String getID() {
        return this.Id;
    }

    /**
     * 取得使用者之病歷號碼
     *
     * @return the id 回傳病歷號碼
     */
    public int getCaseNumber() {
        return this.CaseNumber;
    }

    /**
     * 取得使用者之姓名
     *
     * @return the id 回傳使用者之姓名
     */
    public String getName() {
        return this.Name;
    }

    /**
     * 取得使用者之住址
     *
     * @return the id 回傳使用者之住址
     */
    public String getAddress() {
        return this.Address;
    }

    /**
     * 取得使用者之生日
     *
     * @return the id 回傳使用者之生日
     */
    public Timestamp getBirth() {
        return this.Birth;
    }

    /**
     * 取得使用者之性別
     *
     * @return the id 回傳使用者之性別 (1為女生，0為男生)
     */
    public Boolean getGender() {
        return this.Gender;
    }

    /**
     * 取得使用者之電子信箱
     *
     * @return the id 回傳使用者之電子信箱
     */
    public String getEmail() {
        return this.Email;
    }

    /**
     * 取得使用者之住電話號碼
     *
     * @return the id 回傳使用者之電話號碼
     */
    public String getPhone() {
        return this.Phone;
    }

    /**
     * 取得使用者之住家電話
     *
     * @return the id 回傳使用者之住家電話
     */
    public String getResidenceTel() {
        return this.ResidenceTel;
    }

    /**
     * 取得使用者之血型
     *
     * @return the id 回傳使用者之血型
     */
    public String getBloodType() {
        return this.BloodType;
    }

    /**
     * 取得使用者之身高
     *
     * @return the id 回傳使用者之身高
     */
    public Float getHeight() {
        return this.Height;
    }

    /**
     * 取得使用者之體重
     *
     * @return the id 回傳使用者之體重
     */
    public Float getWeight() {
        return this.Weight;
    }

    /**
     * 取得使用者之過敏史
     *
     * @return the id 回傳使用者之過敏史
     */
    public String getAllergyHistory() {
        return this.AllergyHistory;
    }

    /**
     * 取得使用者之重大疾病史
     *
     * @return the id 回傳使用者之重大疾病史
     */
    public String getServerillHistory() {
        return this.ServillHistory;
    }

    /**
     * 取得使用者之聯絡人姓名
     *
     * @return the id 回傳使用者之聯絡人姓名
     */
    public String getContactName() {
        return this.ContactName;
    }

    /**
     * 取得使用者之聯絡人關係
     *
     * @return the id 回傳使用者之聯絡人關係
     */
    public String getContactRel() {
        return this.ContactRel;
    }

    /**
     * 取得使用者之聯絡人電話
     *
     * @return the id 回傳使用者之聯絡人電話
     */
    public String getContactTel() {
        return this.ContactTel;
    }

    /**
     * 更新使用者資料
     *
     * @return the JSON object 回傳SQL更新之結果與相關封裝之資料
     */
    public JSONObject update() {
        /** 新建一個JSONObject用以儲存更新後之資料 */
        JSONObject data = new JSONObject();

        /** 檢查該名使用者是否已經在資料庫 */
        if (this.Id != "") {
            /** 透過UserHelper物件，更新目前之使用者資料置資料庫中 */
            data = uh.update(this);
        }
        return data;
    }

    /**
     * 取得該名使用者所有資料
     *
     * @return the data 取得該名使用噁之所有資料並封裝於JSONObject物件內
     */
    public JSONObject getData() {
        /** 透過JSONObject將該名使用者所需之資料全部進行封裝 */
        JSONObject jso = new JSONObject();
        jso.put("user_id", getID());
        jso.put("case_number", getCaseNumber());
        jso.put("name", getName());
        jso.put("user_address", getAddress());
        jso.put("user_birth", getBirth());
        jso.put("user_email", getEmail());
        jso.put("user_gener", getGender());
        jso.put("user_phone", getPhone());
        jso.put("residence_tel", getResidenceTel());
        jso.put("blood", getBloodType());
        jso.put("height", getHeight());
        jso.put("weight", getWeight());
        jso.put("allergy_history", getAllergyHistory());
        jso.put("serverill_history", getServerillHistory());
        jso.put("contact_name", getContactName());
        jso.put("contact_rel", getContactRel());
        jso.put("contact_tel", getContactTel());

        return jso;
    }

    /**
     * 從資料庫實作好像比較好
     * /**
     * 計算使用者之病例編號
     * 
     * private void setCaseNumber() {
     * 
     * }
     */
}