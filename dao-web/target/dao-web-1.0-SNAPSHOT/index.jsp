<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script>
        function ok() {
            var packageName = document.getElementById("packageName");
            if(packageName.value == '') {
                alert("请输入包名");
                return false;
            }

            var sql = document.getElementById("sql");
            if(sql.value == '') {
                alert("请输入建表语句");
                return false;
            }
            return true;
        }

        function clear() {
            document.getElementById("packageName").innerHTML = "";
            document.getElementById("sql").innerHTML = "";
            return false;
        }
    </script>
</head>
<body>
<form method="post" action="/hello/create">
    <label style="margin: 10px">包名</label>
    <input type="text" name="packageName" id="packageName"/>
    </br>
    </br>
    </br>
    <textarea rows="30" cols="100" style="margin: 10px" name="sql" id="sql">
        CREATE TABLE `DP_DaoGen` (
`Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '唯一id',
`Name` varchar(200) NOT NULL DEFAULT '' COMMENT '名称',
`EnName` varchar(200) NOT NULL DEFAULT '' COMMENT '英文名，唯一',
`Status` int(11) NOT NULL DEFAULT '0' COMMENT '状态，为0表示不可用',
`AddTime` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00' COMMENT '添加时间',
`UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Dao生成器';
    </textarea>

    </br>
    </br>
    </br>

    <input type="submit" style="margin: 20px" onclick="return ok();" value="生成"/>
    <button onclick="return clear();">清除</button>
</form>

</body>

</html>