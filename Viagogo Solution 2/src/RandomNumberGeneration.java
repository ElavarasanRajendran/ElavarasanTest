/**
 * @author Elavarasan
 *
 */
public class RandomNumberGeneration 		//Class to generate random Numbers
{
	public double randomNumberGenerationMethod(double minimumValue,double maximumValue)
	{
		double  randomNumber;
		randomNumber = randomNumber=Math.random()*maximumValue+minimumValue;
		randomNumber*=100;
		randomNumber=Math.round(randomNumber);
		randomNumber/=100;
		return randomNumber;
	}
}