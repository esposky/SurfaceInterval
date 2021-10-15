package nauiTables;

import java.util.Arrays;

public class DiveLogs {
	SingleLog[] logs;
	
	DiveLogs(SingleLog[] logs) {
		setLogs(logs);
	}
	
	//passes back copy of log list for data integrity to prevent modification of original list
	public SingleLog[] getLogs() {
		SingleLog[] temp = new SingleLog[logs.length];
		for(int i = 0; i < temp.length; i++)
			temp[i] = logs[i];
		return logs;
	}

	private void setLogs(SingleLog[] logs) {
		this.logs = logs;
	}

	@Override
	public String toString() {
		return "DiveLogs [getLogs()=" + Arrays.toString(getLogs()) + "]";
	}

}
