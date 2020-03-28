## Food Truck - SkillDistillery Week 2 Project

### Overview: 
This is an intro project to creating and using objects. I created a food truck class that has several class fields.
Name, UniqueID, MAX_RATING, foodType, rating. I also added all the getters and setters and toString() method to output all the 
object data. The user is able to add food trucks and assign the data at creation and after done adding trucks user is able to view 
the data, see average rating, or view the highest rated food truck. One user is finished there is a menu option to exit the program.

### Technologies used:
- Eclipse
- Vim
- Stackoverflow / Google
- Java
- Terminal Commands

### Lessons Learned
- The biggest obstacle I had when writing this program is that I assumed looping through an array would print out 'null' if
the value at a certain index was null. But It doesn't. I realized that the compliler throws a nullpointerexception at runtime. In
order to fix this, I had to check every iteration of the loop if the value at a certain position was null. If not print it, if not
move on.
- I was also able to better utilize(I believe) Static data in each foodTruck to assign a MAX_RATING value, and create Unique ID's 
for each of the trucks.
