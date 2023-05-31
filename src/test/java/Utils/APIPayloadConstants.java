package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    //we will pass the body in multiple formats, for this we have created this class

    public static String createEmployeePayload(){
        String createEmployeePayload =" {\n" +
                "    \"employee_id\": \"55180A\",\n" +
                "    \"emp_firstname\": \"Gigi\",\n" +
                "    \"emp_lastname\": \"Manini\",\n" +
                "    \"emp_middle_name\": \"m\",\n" +
                "    \"emp_gender\": \"M\",\n" +
                "    \"emp_birthday\": \"1984-05-20\",\n" +
                "    \"emp_status\": \"Probation\",\n" +
                "    \"emp_job_title\": \"Tester\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeePayloadJson(){
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname","Gigi");
        obj.put("emp_lastname","Manini");
        obj.put("emp_middle_name","m");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1984-05-20");
        obj.put("emp_status","Probation");
        obj.put("emp_job_title","Tester");
        return obj.toString();
    }

    public static String createEmployeePayloadDynamic
            (String emp_firstname,String emp_lastname, String emp_middle_name,
             String emp_gender, String emp_birthday,String emp_status,
             String emp_job_title){
        JSONObject obj=new JSONObject();
        obj.put("emp_firstname",emp_firstname);
        obj.put("emp_lastname",emp_lastname);
        obj.put("emp_middle_name",emp_middle_name);
        obj.put("emp_gender",emp_gender);
        obj.put("emp_birthday",emp_birthday);
        obj.put("emp_status",emp_status);
        obj.put("emp_job_title",emp_job_title);
        return obj.toString();
    }

    public static String updateEmployeePayloadJson(){
        JSONObject obj=new JSONObject();
        obj.put("employee_id", "57573A");
        obj.put("emp_firstname","Natalie");
        obj.put("emp_lastname","Glusco");
        obj.put("emp_middle_name","ms");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","2001-04-22");
        obj.put("emp_status","Probation");
        obj.put("emp_job_title","Manager");
        return obj.toString();
    }

    public static String token(){
        String token = "{\n" +
                "  \"email\": \"katyisacat1@test.com\",\n" +
                "  \"password\": \"test123\"\n" +
                "}";
        return token;
    }
}
