package project;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ThreadEX implements Runnable {
	@Override
	public void run() {
		ArrayList<MyExerDTO> list = new ArrayList<MyExerDTO>();
		MyExerDAO dao = new MyExerDAO();
		boolean isThere = true;
		Random r = new Random();
		try {
			while(isThere) {
				list = dao.select(new java.sql.Date(new Date().getTime()), Login.saveId, false);
				if (list.size() <= 0) {
					Thread.sleep(5000);
				}else {
					Thread.sleep(5000);
					int num = r.nextInt(list.size());
					dao.update(list.get(num).getMyeid(), true);
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}