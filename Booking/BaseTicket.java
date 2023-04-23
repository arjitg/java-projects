//Name: Arjit Gupta
//Date: 30th March 2023
//Assignment: PA03

package PA03;

/*Interface for Ticket class*/
public interface BaseTicket {

/*Make the following 2 varibales final*/
final double onCampusBaseCharge  = 1.25;
final double offCampusBaseCharge = 2.34;

/*Fill in to declare the 2 abstract methods as mentioned in the requirement*/
void calculateTicket();
String toString();

}
