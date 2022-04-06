import java.sql.*;

public class DataBaseClass {

    public static String getProfessors(String location) {
        String result = "";
        String url = "jdbc:mysql://localhost:3306/University";
        String username = "root";
        String passwd = "MySKUl_2N6$0__j";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, passwd);

            Statement stmt = connection.createStatement();
            String gui = "select pno , pname, pjob, pmgr, phiredate, psalary, pbonus  from  professor , department  where professor.pdno = department.dno and department.dlocation = \""
                    + location + "\";";

            ResultSet rs2 = stmt.executeQuery(gui);

            while (rs2.next()) {
                int id = rs2.getInt("pno");
                String name = rs2.getString("pname");
                String job = rs2.getString("pjob");
                int mgr = rs2.getInt("pmgr");
                Date hiredate = rs2.getDate("phiredate");
                int salary = rs2.getInt("psalary");
                int bonus = rs2.getInt("pbonus");

                String getmgrname = "select pname from professor where professor.pno = " + mgr + ";";
                Statement statement = connection.createStatement();
                ResultSet mgrnameset = statement.executeQuery(getmgrname);
                String mgrname = "";
                while (mgrnameset.next()) {
                    mgrname = mgrnameset.getString("pname");
                }
                result += ("id - Name: " + id + ", " + name + ", job: " + job + ", manager " + mgrname
                        + ", hired on " + (hiredate) + ", salary: " + salary + ", bonus: " + bonus + "\n");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getDepSummary(String location) {
        String result = "";
        String url = "jdbc:mysql://localhost:3306/University";
        String username = "root";
        String password = "xxx";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement stmt = connection.createStatement();
            String gui = "call getDepSummary(\"" + location + "\");";

            ResultSet rs2 = stmt.executeQuery(gui);

            while (rs2.next()) {
                String pname = rs2.getString("pname");
                String maxSalary = rs2.getString("max(psalary)");
                String minSalary = rs2.getString("min(psalary)");
                String averageSalary = rs2.getString("avg(psalary)");
                String count = rs2.getString("count(*)");

                result += ("Department Name: " + pname + ", Maximum salary: " + maxSalary + " , Minimum dalary: " + minSalary
                        + " , Average dalary: " + averageSalary + " , Number of professors: " + count + "\n");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getDepSummary("Bliss Hall"));
    }
}