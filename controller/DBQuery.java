package controller;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBQuery {
	Connection connectDatabase();
}
