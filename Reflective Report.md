Reflective Report
=================

Initially, I thought the switch from Python to Java would have been quite difficult. Before starting 
his course, I had only ever used Python and had quite little understanding of OOP. However, the change was
quite smooth. The overall logic of the methods was the same; I only had to learn the different command names.
I must also add that surrounding the conditions of some keywords (such as if, catch, etc.) with parentheses
will take some time to get used to as without Intellij I would have never remembered. I also need to remember
to add semicolons at the end of every line!

Regarding the use of version control, I am pretty confident with setting up a GitHub repository and 
accessing it from different computers within the USB as well as from my own personal computer at home.
I know how to commit and push as well as amend previous commits. I do believe, however, that I could work on
how frequently I do perform commits, as I have significantly less total commits in comparison to my peers.
There is also the off-chance that they have committed too much; I am still quite unsure as to how frequent
commits should be and is definitely something that I could work on in the future.

I made a lot of assumptions in this project as I felt that parts of the specification were quite vague. For
example, I decided to make the lot number a 5-digit number that always begins with 1 as it keeps the length
of the lot number consistent. However, the drawback to this is that each AuctionHouse object can only contain
99999 unique items. I believe this is fine as I can always increase the length of the lot number to 6 or 
7-digits in the future if required, though I doubt it is that necessary. Another quite important assumption
made was that I allowed the creation of Item objects without them being associated with an AuctionHouse
object. This was because the specification said that the creation of Item objects should be doable within
the ReportingIO class. To combat the idea that Items can only exist within AuctionHouses, I allowed the 
program to add these newly created Items to newly created AuctionHouses (this simply means that the user can
create the item before the auction house). If I had more time I would ensure that they are not able to create
an item and then leave it without an auction house.

All of my other assumptions can be found commented above the code they're used in.

If I had more time to work on this project, I would implement file handling to allow the storage and
retrieval of all the objects created. This would allow the information to be saved and edited in the future,
even when the program closes. Additionally, I would merge Reporting.addAuctionHouse() and 
Reporting.addItem() as they both have very similar structured code. I would probably do this by passing
another argument into a combined method that chooses between AuctionHouse or Item and then implement the
appropriate method based off the argument's value. Furthermore, some of my methods create temporary objects
with no/null values which was a temporary fix that could be improved upon with more time, albeit
being unsure of what exactly to change regarding this. Furthermore, I would allow the user to return to
previously created AuctionHouses and edit their details themselves, rather than needing to use methods not
implemented in ReportingIO yet. I would also prevent AuctionHouse name duplicates and Item lot number
duplicates.