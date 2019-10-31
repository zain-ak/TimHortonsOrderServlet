package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//PLEASE NOTE: All error checking is done in the front-end so it is impossible for this servlet to receive bad input.
//             In case the user doesn't input any values, all fields have a value by default.
//             The method doGet is not used

@WebServlet(name = "Order", urlPatterns = {"/order"})
public class Order extends HttpServlet {
  private static double totalEarned = 0;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    //super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //super.doPost(req, resp);
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println(printHeader());

    String choice = req.getParameter("slang");
    int numCoffee = Integer.parseInt(req.getParameter("numCoffee"));
    String coffeeSize = req.getParameter("sizeOption");
    int numSugar, numCream;
    numSugar = numCream = -1;

    if (choice != null) {
      switch(choice) {
        case "reg":
          numSugar = numCream = 1;
          break;

        case "dd":
          numSugar = numCream = 2;
          break;

        case "tt":
          numSugar = numCream = 3;
          break;

        case "bl":
          numSugar = numCream = 0;
          break;

        case "bs":
          numCream = 0;
          numSugar = 1;
          break;

        case "bss":
          numCream = 0;
          numSugar = 2;
          break;

        case "bsss":
          numCream = 0;
          numSugar = 3;
          break;
      }
    }
    else {
      numCream = Integer.parseInt(req.getParameter("numCream"));
      numSugar = Integer.parseInt(req.getParameter("numSugar"));
      out.println(numCream + numSugar);
    }


    out.println("<h1 style='color: white; font-family: Arial, Helvetica, sans-serif;'>Great! Here's your Final Order:</h1>");
//    out.println("<p style='color: white;'>" + choice + " " + numCoffee + " " + coffeeSize + " " +
//                 numSugar + " " + numCream + "</p>");

    for (int i = 0; i < numCoffee; i++) {
      out.println("<div class='finalOrderBox'>");
      out.println(displayCup(coffeeSize));
      out.println(manualOrder(numCream, numSugar));
      out.println("</div>");
    }

    out.println(printBill(coffeeSize, numCoffee));
    out.println(printFooter());
  }

  private String printFooter() {
    return "</body>\n" +
      "</html>";
  }

  private String printBill(String coffeeSize, int numCoffee) {
    double price;
    switch (coffeeSize) {
      case "s":
        price = 2 * numCoffee * 1.13;
        totalEarned += price;
        return "<p style='color: white; font-weight: bold; font-size: 2.0em;'>Total Price: " + numCoffee + " coffee(s) x C$3.50 (incl. tax) = $" +
                (Math.round(price * 100.0) / 100.0) + "</p><br><br><p style='color: white; font-weight: bold; font-size: 2.0em;'>Total Earned so far: $" +
                (Math.round(totalEarned * 100.0) / 100.0) + "</p>";
      case "m":
        price = 2.5 * numCoffee * 1.13;
        totalEarned += price;
        return "<p style='color: white; font-weight: bold; font-size: 2.0em;'>Total Price: " + numCoffee + " coffee(s) x C$3.50 (incl. tax) = $" +
                (Math.round(price * 100.0) / 100.0) + "</p><br><br><p style='color: white; font-weight: bold; font-size: 2.0em;'>Total Earned so far: $" +
                (Math.round(totalEarned * 100.0) / 100.0) + "</p>";
      case "l":
        price = 3 * numCoffee * 1.13;
        totalEarned += price;
        return "<p style='color: white; font-weight: bold; font-size: 2.0em;'>Total Price: " + numCoffee + " coffee(s) x C$3.50 (incl. tax) = $" +
                (Math.round(price * 100.0) / 100.0) + "</p><br><br><p style='color: white; font-weight: bold; font-size: 2.0em;'>Total Earned so far: $" +
                (Math.round(totalEarned * 100.0) / 100.0) + "</p>";
      case "xl":
        price = 3.5 * numCoffee * 1.13;
        totalEarned += price;
        return "<p style='color: white; font-weight: bold; font-size: 2.0em;'>Total Price: " + numCoffee + " coffee(s) x C$3.50 (incl. tax) = $" +
          (Math.round(price * 100.0) / 100.0) + "</p><br><br><p style='color: white; font-weight: bold; font-size: 2.0em;'>Total Earned so far: $" +
          (Math.round(totalEarned * 100.0) / 100.0) + "</p>";
    }
    return null;
  }

  private String manualOrder(int numCream, int numSugar) {
    String result = "";
    if (numSugar != 0) {
      result = result.concat("<img src='img/plus.jpg' class='plus'/>");
      for (int i = 0; i < numSugar; i++)
        result = result.concat("<img src='img/sugar.jpg' class='sugar'/>");
    }
    if (numCream != 0) {
      result = result.concat("<img src='img/plus.jpg' class='plus'/>");
      for (int i = 0; i < numCream; i++)
        result = result.concat("<img src='img/cream.jpg' class='cream'/>");
    }
    return result;
  }

  private String displayCup(String coffeeSize) {
    switch (coffeeSize) {
      case "s":
        return "<img src='img/cup.jpg' class='sCoffee'/>";

      case "m":
        return "<img src='img/cup.jpg' class='mCoffee'/>";

      case "l":
        return "<img src='img/cup.jpg' class='lCoffee'/>";

      case "xl":
        return "<img src='img/cup.jpg' class='xlCoffee'/>";
    }
    return null;
  }

  private String printHeader() {
    return "<html lang=\"en\">\n" +
      "<head>\n" +
      "    <meta charset=\"UTF-8\">\n" +
      "    <meta name=\"viewport\" content=\"width=\", initial-scale=1.0\">\n" +
      "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
      "    <title>Your Order</title>\n" +
      "    <link rel=\"shortcut icon\" type=\"image/png\" href=\"favicon.png\"/>\n" +
      "    <link rel=\"stylesheet\" href=\"style.css\"/> \n" +
      "</head>\n" +
      "<body style=\"background-repeat:repeat;\">\n";
  }

}
