package funding.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
>>>>>>> origin/yimoonyeol

public class MainCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD

		HttpSession session = request.getSession();
		session.getAttribute("customer_id");
		
=======
		// TODO Auto-generated method stub

>>>>>>> origin/yimoonyeol
	}

}
