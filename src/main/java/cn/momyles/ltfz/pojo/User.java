package cn.momyles.ltfz.pojo;

import java.io.Serializable;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7965351952346807854L;
	public static final User dao = new User();
}
