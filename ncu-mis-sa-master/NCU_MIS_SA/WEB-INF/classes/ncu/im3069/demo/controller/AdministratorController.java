package ncu.im3069.demo.controller;

import java.io.*;
import java.sql.Timestamp;

import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;
import ncu.im3069.demo.app.Administrator;
import ncu.im3069.demo.app.AdministratorHelper;
import ncu.im3069.demo.app.User;
import ncu.im3069.tools.JsonReader;

// TODO: Auto-generated Javadoc
/**
 * <p>
 * The Class AdministratorController<br>
 * AdministratorController類別（class）主要用於處理Administrator相關之Http請求（Request），繼承HttpServlet
 * </p>
 * 
 * @author IPLab
 * @version 1.0.0
 * @since 1.0.0
 */

public class AdministratorController extends HttpServlet {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** ah，MemberHelper之物件與Administrator相關之資料庫方法（Sigleton） */
    private AdministratorHelper ah = AdministratorHelper.getHelper();

    /**
     * 處理Http Method請求POST方法（新增資料）
     *
     * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
     * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
                JsonReader jsr = new JsonReader(request);
                JSONObject jso = jsr.getObject();

                /** 取出經解析到JSONObject之Request參數 */
                String admin_name = jso.getString("admin_name");
                String admin_mail = jso.getString("admin_mail");
                String admin_password = jso.getString("admin_password");

                /** 建立一個新的admin物件 */
                Administrator a = new Administrator(admin_name, admin_mail, admin_password);

                /** 後端檢查是否有欄位為空值，若有則回傳錯誤訊息 */
                if (admin_name.isEmpty() || admin_mail.isEmpty() || admin_password.isEmpty()) {
                        /** 以字串組出JSON格式之資料 */
                        String resp = "{\"status\": \'400\', \"message\": \'欄位不能有空值\', \'response\': \'\'}";
                        /** 透過JsonReader物件回傳到前端（以字串方式） */
                        jsr.response(resp, response);
                }
                /** 透過AdministratorHelper物件的checkDuplicate()檢查該admin之email是否有重複 */
                else if (!ah.checkDuplicate(a)) {
                        /** 透過AdministratorHelper物件的create()方法新建一個管理者至資料庫 */
                        JSONObject data = ah.create(a);

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "成功! 新增管理者資料...");
                        resp.put("response", data);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                } else {
                        /** 以字串組出JSON格式之資料 */
                        String resp = "{\"status\": \'400\', \"message\": \'新增門診失敗，管理者名稱重複！\', \'response\': \'\'}";
                        /** 透過JsonReader物件回傳到前端（以字串方式） */
                        jsr.response(resp, response);
                }
    }

    /**
     * 處理Http Method請求GET方法（取得資料）
     *
     * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
     * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
                JsonReader jsr = new JsonReader(request);
                /** 若直接透過前端AJAX之data以key=value之字串方式進行傳遞參數，可以直接由此方法取回資料 */
                String mail = jsr.getParameter("mail");

                /** 判斷該字串是否存在，若存在代表要取回個別admin資料，否則代表要取回全部資料庫內admin之資料 */
                if (mail.isEmpty()) {
                        /** 透過AdministratorHelper物件之getAll()方法取回所有admin之資料，回傳之資料為JSONObject物件 */
                        JSONObject query = ah.getAll();

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "所有管理者資料取得成功");
                        resp.put("response", query);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                } else {
                        /** 透過adminHelper物件的getByID()方法自資料庫取回該admin之資料，回傳之資料為JSONObject物件 */
                        JSONObject query = ah.getByMail(mail);

                        /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                        JSONObject resp = new JSONObject();
                        resp.put("status", "200");
                        resp.put("message", "管理者資料取得成功");
                        resp.put("response", query);

                        /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                        jsr.response(resp, response);
                }
    }

    /**
     * 處理Http Method請求DELETE方法（刪除）
     *
     * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
     * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
     * @throws ServletException the servlet exception
     * @throws IOException      Signals that an I/O exception has occurred.
     */
    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                /** 透過JsonReader類別將Request之JSON格式資料解析並取回 */
                JsonReader jsr = new JsonReader(request);
                JSONObject jso = jsr.getObject();

                /** 取出經解析到JSONObject之Request參數 */
                int id = jso.getInt("id");

                /** 透過AdministratorHelper物件的deleteByID()方法至資料庫刪除該管理者，回傳之資料為JSONObject物件 */
                JSONObject query = ah.deleteByID(id);

                /** 新建一個JSONObject用於將回傳之資料進行封裝 */
                JSONObject resp = new JSONObject();
                resp.put("status", "200");
                resp.put("message", "管理者移除成功！");
                resp.put("response", query);

                /** 透過JsonReader物件回傳到前端（以JSONObject方式） */
                jsr.response(resp, response);
    }

//     /**
//      * 處理Http Method請求PUT方法（更新）
//      *
//      * @param request  Servlet請求之HttpServletRequest之Request物件（前端到後端）
//      * @param response Servlet回傳之HttpServletResponse之Response物件（後端到前端）
//      * @throws ServletException the servlet exception
//      * @throws IOException      Signals that an I/O exception has occurred.
//      */
//     public void doPut(HttpServletRequest request, HttpServletResponse response)
//             throws ServletException, IOException {

//     }
}
