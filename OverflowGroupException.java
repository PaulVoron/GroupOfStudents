package com.gmail.voron.paul;

public class OverflowGroupException extends Exception {
	@Override
	public String getMessage() {
		return "Нет места. Группа сформирована полностью.";
	}

}
