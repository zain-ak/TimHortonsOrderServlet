<%--
  Created by IntelliJ IDEA.
  User: Zain
  Date: 10/21/19
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Tim Horton's Ordering JSP</title>
  <link rel="shortcut icon" type="image/png" href="favicon.png"/>
  <link rel="stylesheet" href="style.css"/>
</head>
<body>
<h1 style="color: white; font-family: Arial, Helvetica, sans-serif;">Tim Horton's Online Ordering Web App</h1>
<div class="orderBox">
  <h3>Place your order below:</h3>
  <table>
    <form action="order" method="POST">
      <tr><td>Number of Coffees:&nbsp;</td><td><input type="number" name="numCoffee" min="1" max="20" width="2" value="1" required></td></tr>
      <tr><td>Coffee Size:&nbsp;</td><td><select name="sizeOption">
        <option value="s" selected="selected">Small</option>
        <option value="m">Medium</option>
        <option value="l">Large</option>
        <option value="xl">Extra Large</option>
      </select></td>
      </tr>
      <tr><td>Cream:&nbsp;</td><td><input type="number" name="numCream" min="0" max="5" width="2" value="1" required></td></tr>
      <tr><td>Sugar:&nbsp;</td><td><input type="number" name="numSugar" min="0" max="5" width="2" value="1" required></td></tr>
      <tr><td></td><td></td><td><input type="submit" value="Place Order"></td></tr>
    </form>
  </table>

</div>

<div class="orderBox">
  <h3>Place your order using the Slang:</h3>
  <table>
    <form action="order" method="POST">
      <tr><td>Number of Coffees:&nbsp;</td><td><input type="number" name="numCoffee" min="1" max="20" width="2" value="1" required></td></tr>
      <tr><td>Coffee Size:&nbsp;</td><td><select name="sizeOption">
        <option value="s" selected="selected">Small</option>
        <option value="m">Medium</option>
        <option value="l">Large</option>
        <option value="xl">Extra Large</option>
      </select></td>
      </tr>
      <tr><td>Regular <input type="radio" name="slang" value="reg" checked="checked"></tr>
      <tr><td>Double Double <input type="radio" name="slang" value="dd"></td></tr>
      <tr><td>Triple Triple <input type="radio" name="slang" value="tt"></td></tr>
      <tr><td>Black <input type="radio" name="slang" value="bl"></td></tr>
      <tr><td>Black w/ one sugar <input type="radio" name="slang" value="bs"></td></tr>
      <tr><td>Black w/ two sugar<input type="radio" name="slang" value="bss"></td></tr>
      <tr><td>Black w/ three sugar <input type="radio" name="slang" value="bsss"></td></tr>
      <tr><td></td><td></td><td><input type="submit" value="Place Order"></td></tr>
    </form>
  </table>
</div>
</body>
</html>
