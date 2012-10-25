SpaceTrader
===========

Georgia Tech Fall 2012 CS 2340 Semester Project  

*Game Board Size:* 200x200  
*Solar Systems Amount:* 150 (each system is generated >9 units away from every other system)  
*Solar System Names:* Randomly chosen from "PlanetsNames.txt".  


<table>
  <tr>
    <th>Name</th><th>MTLP</th><th>MTLU</th><th>TTP</th><th>PriceDecrease</th><th>PriceIncrease</th><th>BasePrice</th><th>BaseQuantity</th>
  </tr>
  <tr>
    <td>Water</td><td>0</td><td>0</td><td>2</td><td>LOTSOFWATER</td><td>DROUGHT</td><td>30</td><td>25</td>
  </tr>
  <tr>
 	<td>Furs</td><td>0</td><td>0</td><td>0</td><td>RICHFAUNA</td><td>LIFELESS</td><td>250</td><td>10</td>
  </tr>
  <tr>
 	<td>Food</td><td>1</td><td>0</td><td>1</td><td>RICHSOIL</td><td>POORSOIL</td><td>100</td><td>20</td>
  </tr>
  <tr>
 	<td>Ore</td><td>2</td><td>2</td><td>3</td><td>MINERALRICH</td><td>MINERALPOOR</td><td>350</td><td>20</td>
  </tr>
  <tr>
 	<td>Firearms</td><td>3</td><td>1</td><td>5</td><td>WARLIKE</td><td>(never)</td><td>1200</td><td>5</td>
  </tr>
  <tr>
 	<td>Medicine</td><td>4</td><td>1</td><td>6</td><td>LOTSOFHERBS</td><td>(never)</td><td>650</td><td>15</td>
  </tr>
  <tr>
 	<td>Machines</td><td>4</td><td>3</td><td>5</td><td>(never)</td><td>(never)</td><td>900</td><td>10</td>
  </tr>
  <tr>
 	<td>Narcotics</td><td>5</td><td>0</td><td>5</td><td>WEIRDMUSHROOMS</td><td>(never)</td><td>3500</td><td>5</td>
  </tr>
  <tr>
 	<td>Robots</td><td>6</td><td>4</td><td>6</td><td>(never)</td><td>(never)</td><td>5000</td><td>5</td>
  </tr>
</table>

<dl>
  <dt>MTLP</dt>
  <dd>Minimum technology level a planet needs to sell this item.</dd>
  <dt>MTLU</dt>
  <dd>Minimum technology level a planet needs to buy this item from a player.</dd>
  <dt>TTP</dt>
  <dd>Required technology level for a planet to have a greater quantity of that item. Current rate is +50%/-50%.</dd>
  <dt>Price Increase / Price Decrease</dt>
  <dd>Current rate is +25%/-25%</dd>
</dl>



