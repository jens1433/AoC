String[] commands = loadStrings("input.txt");
int depth = 0;
int horizontal = 0;

// Part 1
for(String command : commands)
{
  String[] split = command.split(" ");
  int amount = int(split[1]);
  switch(split[0]) {
    case "forward":
    horizontal += amount;
    break;
    case "up":
    depth -= amount;
    break;
    case "down":
    depth += amount;
    break;
  }
}

println(depth * horizontal);

// Part 2
depth = 0;
horizontal = 0;
int aim = 0;
for(String command : commands)
{
  String[] split = command.split(" ");
  int amount = int(split[1]);
  switch(split[0]) {
    case "forward":
    horizontal += amount;
    depth += aim * amount;
    break;
    case "up":
    aim -= amount;
    break;
    case "down":
    aim += amount;
    break;
  }
}

println(depth * horizontal);
