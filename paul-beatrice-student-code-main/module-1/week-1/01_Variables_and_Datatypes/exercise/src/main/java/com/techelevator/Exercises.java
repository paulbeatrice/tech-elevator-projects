package com.techelevator;

public class Exercises {
	public static void main(String[] args)



		/*
		 * For the purposes of this exercise, the following naming rules are tested:
		 * <p>
		 * Variable names:
		 * - must start with a lowercase character a-z.
		 * - underscore ('_') characters are not allowed.
		 * - dollar sign ('$') characters are not allowed.
		 * - must be at least two characters in length.
		 * - You are encouraged to create descriptive names and are required to camel case them as appropriate.
		 * <p>
		 * Constant names:
		 * - must start with an uppercase character A-Z.
		 * - dollar sign ('$') characters are not allowed.
		 * - must be at least two characters in length.
		 * - You are encouraged to create descriptive names and are required to upper case them as appropriate.
		 * <p>
		 * Due to practical limitations, camel case and pascal case are not tested other than checking the first
		 * character of the name is lower case for variables and upper case for constants. Your instructor will
		 * manually review your solution checking for the correct casing.
		 */ {
        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		int totalBirdsStart = 4;
		int birdsflyaway = 1;
		// calculation for results
		int totalBirdsLeft = totalBirdsStart - birdsflyaway; // expected results

		System.out.println(totalBirdsLeft);




	 /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		int totalBirds = 6;
		int totalNests = 3;
		// calculation for results
		int differenceOfBirdsAndNests = totalBirds - totalNests; // expected results

		System.out.println(totalBirds - totalNests);





        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int raccoonsPlaying = 3;
		int raccoonsHome = 2;
		// calculation for results
		int raccoonsLeft = raccoonsPlaying - raccoonsHome; // expected result

		System.out.println(raccoonsLeft);





        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		//calculation for result
		int differenceOfFlowersAndBees = numberOfFlowers - numberOfBees; // expected result

		System.out.println(differenceOfFlowersAndBees);












        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int lonelyPigeon = 1;
		int anotherPigeon = 1;
		// calculation for results
		int totalPigeons = lonelyPigeon + anotherPigeon;

		System.out.println(totalPigeons);








        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int owlsOnFence = 3;
		int owlsJoining = 2;
		// calculation
		int totalOwls = owlsOnFence + owlsJoining;

		System.out.println(totalOwls);





        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int beaversWorking = 2;
		int beaversSwimming = 1;
		// calculation
		int hardWorkingBeaver = beaversWorking - beaversSwimming;

		System.out.println(hardWorkingBeaver);

		;


        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int toucansOnTreeLimb = 2;
		int friendlyToucan = 1;
		//calculation
		int toucansHangingOut = toucansOnTreeLimb + friendlyToucan;

		System.out.println(toucansHangingOut);




        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int numberOfSquirrels = 4;
		int numberOfNuts = 2;
		//calculation
		int differenceOfSquirrelsAndNuts = numberOfSquirrels - numberOfNuts;

		System.out.println(differenceOfSquirrelsAndNuts);







/* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double amountInQuarters = .25;
		double amountInDimes = .10;
		double amountInNickels = .10;
		// calculation of how much money she has
		double totalMoney = amountInDimes + amountInNickels + amountInQuarters;

		System.out.println(totalMoney);



        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */

		int mrsBriers = 18;
		int mrsMacAdams = 20;
		int mrsFlannery = 17;
		// calculation
		int totalMuffins = mrsBriers + mrsFlannery + mrsMacAdams;

		System.out.println(totalMuffins);


        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double yoYoPrice = .24;
		double whistlePrice = .14;
		//calculation
		double totalSpent = yoYoPrice + whistlePrice;

		System.out.println(totalSpent);


        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		//calculation
		int totalMarshmallows = largeMarshmallows + miniMarshmallows;

		System.out.println(totalMarshmallows);




        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int snowMrsHiltsHouse = 29;
		int snowBrecknock = 17;
		//calculation
		int differenceOfSnow = snowMrsHiltsHouse - snowBrecknock;

		System.out.println(differenceOfSnow);


        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2.50 on a pencil
        case. How much money does she have left?
        */
		double mrsHiltMoney = 10;
		double toyTruck = 3;
		double pencilCase = 2.50;
		//calculation
		double moneyLeft = mrsHiltMoney - (toyTruck + pencilCase);

		System.out.println(moneyLeft);




        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int joshCollection = 16;
		int lostMarbles = 7;
		//calculation
		int marblesLeft = joshCollection - lostMarbles;

		System.out.println(marblesLeft);



        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int meganSeashells = 19;
		int totalSeashells = 25;
		// calculation
		int seaShellsNeed = totalSeashells - meganSeashells;

		System.out.println(seaShellsNeed);



        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int bradsBalloons = 17;
		int redBalloons = 8;
		// calculation
		int greenBalloons = bradsBalloons - redBalloons;
		System.out.println(greenBalloons);




        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int booksOnShelf = 38;
		int addedBooks = 10;
		//calculation
		int totalBooks = booksOnShelf + addedBooks;

		System.out.println(totalBooks);



        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int beeLegs = 6;
		int totalOfBees = 8;
		//calculation
		int totalBeeLegs = beeLegs * totalOfBees;

		System.out.println(totalBeeLegs);




        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double costIceCreamCone = .99;
		double numberOfIceCreamCones = 2;
		//calculation
		double totalCostIceCreamCones = costIceCreamCone * numberOfIceCreamCones;

		System.out.println(totalCostIceCreamCones);




        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int totalRocks = 125;
		int rocksAvailable = 64;
		//calculation
		int rocksNeeded = totalRocks - rocksAvailable;

		System.out.println(rocksNeeded);


        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

		int mrsHiltMarbles = 38;
		int lostHiltMarbles = 15;
		//calculation
		int remainingMarbles = mrsHiltMarbles - lostHiltMarbles;

		System.out.println(remainingMarbles);



        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int milesConcert = 78;
		int milesDriven = 32;
		// calc
		int milesRemaining = milesConcert - milesDriven;

		System.out.println(milesRemaining);



        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int saturdayMorning = 90;
		int saturdayAfternoon = 45;
		// calculation
		int totalMinutesShovelingSnow = saturdayMorning + saturdayAfternoon;

		System.out.println(totalMinutesShovelingSnow);



        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		double mrsHiltHotDogs = 6;
		double costOfHotDogs = .50;
		// calculation
		double totalCostOfHotDogs = mrsHiltHotDogs * costOfHotDogs;

		System.out.println(totalCostOfHotDogs);



        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int pencilCosts = 7;
		int moneyForPencils = 50;
		//calculation
		int numberOfPencils = (moneyForPencils / pencilCosts);

		System.out.println(numberOfPencils);





        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int totalButterfliesSeen = 33;
		int orangeButterflies = 20;
		//calculation
		int redButterflies = totalButterfliesSeen - orangeButterflies;

		System.out.println(redButterflies);



        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */

		double katesMoney = 1.00;
		double candyCost = .54;
		//calculation
		double katesChange = katesMoney - candyCost;

		System.out.println(katesChange);




        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int markTrees = 13;
		int additionalTrees = 12;
		// calculation
		int totalMarkTrees = markTrees + additionalTrees;

		System.out.println(totalMarkTrees);



        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int hoursInDays = 24;
		int dayUntilGrandma = 2;
		//calculation
		int hoursUntilSeen = hoursInDays * dayUntilGrandma;

		System.out.println(hoursUntilSeen);



        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int kimsCousins = 4;
		int piecesOfGumEach = 5;
		// calculation
		int totalGumNeeded = kimsCousins * piecesOfGumEach;

		System.out.println(totalGumNeeded);



        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double dansMoney = 3.0;
		double candyBarCost = 1.0;
		//calculation
		double dansMoneyLeft = dansMoney - candyBarCost;

		System.out.println(dansMoneyLeft);





        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsInLake = 5;
		int peopleInBoats = 3;
		//calculation
		int peopleInBoatsOnLake = boatsInLake * peopleInBoats;

		System.out.println(peopleInBoatsOnLake);



        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int ellensLegos = 380;
		int lostLegos = 57;
		//calculation
		int remainingLegos = ellensLegos - lostLegos;

		System.out.println(remainingLegos);




        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int muffinsNeeded = 83;
		int muffinsBaked = 35;
		//calculation
		int remainingMuffinsNeeded = muffinsNeeded - muffinsBaked;

		System.out.println(remainingMuffinsNeeded);



        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willysCrayons = 1400;
		int lucysCrayons = 290;
		//calculation
		int differenceOfCrayons = willysCrayons - lucysCrayons;

		System.out.println(differenceOfCrayons);



        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickerPerPage = 10;
		int pagesOfStickers = 22;
		//calculation
		int totalAmountOfStickers = stickerPerPage * pagesOfStickers;

		System.out.println(totalAmountOfStickers);



        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double totalCupcakes = 100.0;
		double totalChildren = 8.0;
		//calculation
		double cupcakesPerChild = (totalCupcakes / totalChildren);

		System.out.println(cupcakesPerChild);



	/* Exercise 40
	40. She made 47 gingerbread cookies which she will distribute equally in
	tiny glass jars. If each jar is to contain six cookies, how many
	cookies will not be placed in a jar?
	*/
		int totalGingerBread = 47;
		int cookiesPerJar = 6;
		//calculation
		int cookiesInJar = (totalGingerBread / cookiesPerJar);
		int totalCookiesInJar = cookiesInJar * cookiesPerJar;
		int cookiesNotInJar = (totalGingerBread - totalCookiesInJar);

		System.out.println(cookiesNotInJar);



        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */
		int totalCroissants = 59;
		int numberOfNeighbors = 8;
		int croissantsPerNeighbor = (totalCroissants / numberOfNeighbors);
		int totalCroissantsGiven = croissantsPerNeighbor * numberOfNeighbors;
		int totalCroissantsLeft = totalCroissants - totalCroissantsGiven;

		System.out.println(totalCroissantsLeft);





        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int totalOatmealCookies = 276;
		int cookiesPerTray = 12;
		// calculation
		int totalTrays = (totalOatmealCookies / cookiesPerTray);

		System.out.println(totalTrays);



        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int totalPretzels = 480;
		int pretzelsPerServing = 12;
		//calculation
		int servingsPrepared = (totalPretzels / pretzelsPerServing);

		System.out.println(servingsPrepared);





        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

		int lemonCupcakesBaked = 53;
		int cupcakesLeft = 2;
		int cupcakesPerBox = 3;
		//calculation to find remaining cupcakes
		int totalCupcakesGiven = lemonCupcakesBaked - cupcakesLeft;
		//calculation to find how many boxes with 3
		int boxesOfThree = (totalCupcakesGiven / cupcakesPerBox);

		System.out.println(boxesOfThree);



        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int carrotSticksPrepared = 74;
		int numberOfPeople = 12;
		// calculation for carrots served
		int totalCarrotsPerPerson = (carrotSticksPrepared / numberOfPeople);
		//calculation for total carrots distributed
		int totalCarrotsDistributed = totalCarrotsPerPerson * numberOfPeople;
		// calculation for carrot sticks that were left uneaten
		int uneatenCarrots = carrotSticksPrepared - totalCarrotsDistributed;

		System.out.println(uneatenCarrots);




        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int totalTeddyBears = 98;
		int teddyBearsPerShelf = 7;
		// calculation of shelves
		int totalNumberOfShelves = (totalTeddyBears / teddyBearsPerShelf);

		System.out.println(totalNumberOfShelves);


        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int totalPictures = 480;
		int picturesPerAlbum = 20;
		//calculation
		int totalAlbums = (totalPictures / picturesPerAlbum);

		System.out.println(totalAlbums);


        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int joesTradingCards = 94;
		int cardsPerBox = 8;
		//calculation of filled boxes
		int totalFilledBoxes = (joesTradingCards / cardsPerBox);
		//calculation of total cards in boxes
		int totalCardsInBoxes = totalFilledBoxes * cardsPerBox;
		//calculation of cards in unfilled box
		int totalCardsInUnfilledBox = joesTradingCards - totalCardsInBoxes;

		System.out.println(totalCardsInUnfilledBox);


        /* Exercise 49
        49. The Milky Way galaxy contains 300 billion stars. The Andromeda galaxy
        contains 1 trillion stars. How many stars do the two galaxies contain combined?
        */
		long milkyWayStars = 300_000_000_000L;
		long adromedaGalaxyStars = 1_000_000_000_000L;
		//calculation
		long totalCombinedStars = milkyWayStars + adromedaGalaxyStars;

		System.out.println(totalCombinedStars);



        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */

		double cristinasBakedCroissants = 17.0;
		double totalAmountOfGuests = 7.0;
		//calculation
		double croissantsPerGuests = (cristinasBakedCroissants / totalAmountOfGuests);

		System.out.println(croissantsPerGuests);

	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
	    and then divide the total number of rooms to be painted by the combined rate.
	    */
		double billsTimeToPaint = 2.15;
		double jillsTimeToPaint = 1.90;
		double roomsNeedingPainting = 5.0;
		//calculation
		double billsRate = ( 1 / billsTimeToPaint );
		double jillsRate = ( 1 / jillsTimeToPaint );

		//calculation for combined rates
		double combinedRates = billsRate + jillsRate;
		double numberRoomsPainted = ( roomsNeedingPainting / combinedRates );

		System.out.println(numberRoomsPainted);

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
		String firstName = "Grace";
		String lastName = "Hopper";
		char middleInitial = 'B';

		//full name
		String fullName = lastName + "," + " " + firstName + " " + middleInitial + ".";

		System.out.println(fullName);



	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		int distanceBetweenNewYorkAndChicago = 800;
		int distanceTrainTravelled = 537;
		//calculation for percentage
		int percentage = (distanceTrainTravelled * 100) / 800;

		System.out.println(percentage);
	}

	}
