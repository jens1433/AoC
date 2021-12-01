int[] depths = int(loadStrings("input.txt"));
int prevDepth = depths[0];
int prevSum = depths[0] + depths[1] + depths[2];
int largerSum = 0;
int largerDepth = 0;

// Part 1
for(int iDepth = 1; iDepth < depths.length; iDepth++)
{
  if(depths[iDepth] > prevDepth)
  {
    largerDepth++;
  }
  prevDepth = depths[iDepth];
}

println(largerDepth);

// Part 2
for(int iDepth = 0; iDepth < depths.length - 2; iDepth++)
{
  int sum = depths[iDepth] + depths[iDepth + 1] + depths[iDepth + 2];
  if(sum > prevSum)
  {
    largerSum++;
  }
  prevSum = sum;
}

println(largerSum);
