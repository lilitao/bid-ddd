

## Prepare DB

```sql
CREATE DATABASE IF NOT EXISTS bid COLLATE = 'utf8_general_ci' CHARACTER SET = 'utf8';
GRANT ALL ON bid.* TO 'bid'@'%' IDENTIFIED BY 'bidpassword';
GRANT ALL ON bid.* TO 'bid'@'localhoslst' IDENTIFIED BY 'bidpassword';

CREATE DATABASE IF NOT EXISTS bidentitytest COLLATE = 'utf8_general_ci' CHARACTER SET = 'utf8';
GRANT ALL ON bid.* TO 'bidentitytest'@'%' IDENTIFIED BY 'bidentitytestpassword';
GRANT ALL ON bid.* TO 'bidentitytest'@'localhoslst' IDENTIFIED BY 'bidentitytestpassword';
```


