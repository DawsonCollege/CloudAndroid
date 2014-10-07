package ca.campbell.cloudAndroid1;

public class Constants {
	// todo: URL should be read from config file
	public final static String siteUrl = "http://php54-dawsoncloud.rhcloud.com/";
	public final static String TAG = "CELEBDB";
	public final static int LVMAX = 15;
	public final static String urlByYear = siteUrl + "/db.php?year=";
	public final static String urlById = siteUrl + "/byid.php?id=";
	public final static int BUFFSIZE = 8192; // 8K

}

/*
 * The php components correspond to code on the server.
 * http://php54-dawsoncloud.rhcloud.com/db.php etc
 * Included here for illustration, as is the database create statement.
 */
/*
 * db.php: 
 * oo code
 <?php
$dbname="peopledata";
$table="people";
$sql="SELECT  id, name, imageUrl, sex, birthyear FROM " . $table ;
$mysqli = new mysqli(
                getenv('OPENSHIFT_MYSQL_DB_HOST'),
                getenv('OPENSHIFT_MYSQL_DB_USERNAME'),
                getenv('OPENSHIFT_MYSQL_DB_PASSWORD'),
                $dbname,
                getenv('OPENSHIFT_MYSQL_DB_PORT'));
if ($mysqli->connect_errno) {
        print    ("[{\"error\":\"db connect error:"
                . $mysqli->connect_error."\"}]");
} else  {
        $sql="SELECT  id, name, imageUrl, sex, birthyear FROM " . $table ;
        if (array_key_exists("year", $_REQUEST)) {
                $res = $mysqli->query($sql." WHERE birthyear>".$_REQUEST['year']);
        } else {
                $res = $mysqli->query($sql);
        }
        while ($row = $res->fetch_assoc()) {
                $output[]=$row;
        }
        if (isset($output)) {
                print(json_encode($output));
        } else {
                print("[{\"error\":\"no match\"}]");
        }
        $res->free();
}
*/
/*
 * byid.php:
 * oo code
<?php
$dbname="peopledata";
$table="people";
$sql="SELECT  id, name, imageUrl, sex, birthyear FROM " . $table ;
$mysqli = new mysqli(
                getenv('OPENSHIFT_MYSQL_DB_HOST'),
                getenv('OPENSHIFT_MYSQL_DB_USERNAME'),
                getenv('OPENSHIFT_MYSQL_DB_PASSWORD'),
                $dbname,
                getenv('OPENSHIFT_MYSQL_DB_PORT'));
if ($mysqli->connect_errno) {
        print    ("[{\"error\":\"db connect error:"
                . $mysqli->connect_error."\"}]");
} else  {
        $sql="SELECT  id, name, imageUrl, sex, birthyear FROM " . $table ;
        if (array_key_exists("id", $_REQUEST)) {
                $res = $mysqli->query($sql." WHERE id =".$_REQUEST['id']);
        } else {
                $res = $mysqli->query($sql);
        }
        while ($row = $res->fetch_assoc()) {
                $output[]=$row;
        }
        if (isset($output)) {
                print(json_encode($output));
        } else {
                print("[{\"error\":\"no match\"}]");
        }
        $res->free();
}

*/
/*
* use peopledata;
* CREATE TABLE IF NOT EXISTS `people` (
*  `id` int(11) NOT NULL AUTO_INCREMENT, 
*  `name` varchar(100) NOT NULL,
*  `imageUrl` varchar(50) NOT NULL, 
*  `sex` tinyint(1) NOT NULL DEFAULT '1',
*  `birthyear` int(11) NOT NULL,
*   PRIMARY KEY (`id`)  );
*/