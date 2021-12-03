
void setup() 
{
  String[] report = loadStrings("input.txt");
  ArrayList<String> reportList = new ArrayList<String>();
  int gammaRate = 0;
  int epsilonRate = 0;

  // Part 1
  String gammaBits = "";
  String epsilonBits = "";

  for (int iPlace = 0; iPlace < report[0].length(); iPlace++) 
  {
    String commonBit = commonBit(report, iPlace);
    gammaBits += commonBit;
    epsilonBits += commonBit.equals("1") ? "0" : "1";
  }
  gammaRate = Integer.parseInt(gammaBits, 2);
  epsilonRate = Integer.parseInt(epsilonBits, 2);

  println(gammaRate * epsilonRate);

  // Part 2

  int oxygen = 0;
  int scrubber = 0;
  ArrayList<String> oxyOutput = new ArrayList<String>();

  for (int iPlace = 0; iPlace < report[0].length(); iPlace++) 
  {
    if(oxyOutput.size() == 0) 
    {
      String commonBit = commonBit(report, 0);
      println(commonBit);
      for(int i = 0; i < report.length; i++) 
      {
        if(report[i].substring(0, 1).equals(commonBit)) 
        {
          oxyOutput.add(report[i]);
        }
      }
    } else if(oxyOutput.size() > 1) {
      String commonBit = commonBit(oxyOutput.toArray(new String[0]), iPlace);
      println(commonBit);
      for(int i = 0; i < oxyOutput.size(); i++) 
      {
        if(!oxyOutput.get(i).substring(iPlace, iPlace + 1).equals(commonBit)) 
        {
          oxyOutput.remove(oxyOutput.get(i));
        }
      }
    }
    println(oxyOutput.size());
    println(oxyOutput.get(0));
  }
}

String commonBit(String[] bits, int bit) 
{
  int zeroCounter = 0;
  int oneCounter = 0;
  for (int i = 0; i < bits.length; i++) 
  {
    String single = bits[i].substring(bit, bit + 1);
    if (single.equals("0")) 
    {
      zeroCounter++;
    } else 
    {
      oneCounter++;
    }
  }
  if (zeroCounter > oneCounter) 
  {
    return "0";
  } else 
  {
    return "1";
  }
}
