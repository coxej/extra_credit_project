import java.io.*;

public class app
{
	public static void main(String[] args)
	{
		String s;
        Process p;
        try {
        	// Test
            // p = Runtime.getRuntime().exec("cat /unitime/doc/mysql/schema.sql");

            // schema.sql
            p = Runtime.getRuntime().exec("sudo mysql -uroot -pLollipop1! -f </unitime/doc/mysql/schema.sql");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();

            // woebegon-data.sql
            p = Runtime.getRuntime().exec("sudo mysql -utimetable -punitime <unitime/doc/mysql/woebegon-data.sql");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();            

            // mkdir
            p = Runtime.getRuntime().exec("mkdir /var/lib/tomcat8/data");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();

            // chown
            p = Runtime.getRuntime().exec("chown tomcat8 /var/lib/tomcat8/data");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();

            // copy
            p = Runtime.getRuntime().exec("cp unitime/web/UniTime.war /var/lib/tomcat8/webapps");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();

            // start server
            p = Runtime.getRuntime().exec("/etc/init.d/tomcat8 start");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();

            // DONE
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) { System.out.println(e); }
	}
}