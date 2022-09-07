package statesAndCapitals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StatesAndCapitalsCheck
{
    public static boolean basic1(List<StateInfo> firstFiveStates)
    {
        if (firstFiveStates == null)
            return false;

        String firstFiveStateNames = "";

        for (StateInfo state : firstFiveStates)
        {
            firstFiveStateNames += state.getStateName();
        }

        String expectedStates = "AlabamaAlaskaArizonaArkansasCalifornia";

        return expectedStates.equals(firstFiveStateNames);
    }

    public static boolean basic2(List<StateInfo> lastFiveStates)
    {
        if (lastFiveStates == null)
            return false;

        String lastFiveStateNames = "";

        for (StateInfo state : lastFiveStates)
        {
            lastFiveStateNames += state.getStateName();
        }

        String expectedStates = "VirginiaWashingtonWest VirginiaWisconsinWyoming";

        return expectedStates.equals(lastFiveStateNames);
    }

    public static boolean basic3(List<Integer> firstFiveNumbers)
    {
        if (firstFiveNumbers == null)
            return false;

        String expectedNumbers = "[1, 2, 3, 4, 5]";

        return expectedNumbers.equals(firstFiveNumbers.toString());
    }

    public static boolean basic4(List<Integer> lastFiveNumbers)
    {
        if (lastFiveNumbers == null)
            return false;

        String expectedNumbers = "[16, 17, 18, 19, 20]";

        return expectedNumbers.equals(lastFiveNumbers.toString());
    }

    public static boolean basic5(Long totalNumberOfStates)
    {
        if (totalNumberOfStates == null)
            return false;

        return (totalNumberOfStates == 50);
    }

    public static boolean int1(StateInfo cardinalState)
    {
        if (cardinalState == null)
            return false;

        String[] expectedCardinalStatesArray = {"Indiana", "Kentucky", "North Carolina", "Ohio", "Virginia", "West Virginia"};
        List<String> expectedCardinalStates = Arrays.asList(expectedCardinalStatesArray);

        return (expectedCardinalStates.contains(cardinalState.getStateName()));
    }

    public static boolean int2(Boolean isAnyStateLessThan0Elevation)
    {
        if (isAnyStateLessThan0Elevation == null)
            return false;

        return isAnyStateLessThan0Elevation == true;
    }

    public static boolean int3(Boolean isAnyStateGreaterThan21000Elevation)
    {
        if (isAnyStateGreaterThan21000Elevation == null)
            return false;

        return isAnyStateGreaterThan21000Elevation == false;
    }

    public static boolean int4(Boolean doAllStatesHaveAnAnthem)
    {
        if (doAllStatesHaveAnAnthem == null)
            return false;

        return doAllStatesHaveAnAnthem == false;
    }

    public static boolean int5(Boolean doNoStatesHaveAOneWordMotto)
    {
        if (doNoStatesHaveAOneWordMotto == null)
            return false;

        return doNoStatesHaveAOneWordMotto == false;
    }

    public static boolean adv11(Double averageYearlyPrecipitationAcrossStateCapitals)
    {
        if (averageYearlyPrecipitationAcrossStateCapitals == null)
            return false;

        if (averageYearlyPrecipitationAcrossStateCapitals > 35.979
                && averageYearlyPrecipitationAcrossStateCapitals < 35.981)
        {
            return true;
        }

        return false;
    }

    public static boolean adv12(Integer totalYearlyPrecipitationAcrossStateCapitals)
    {
        if (totalYearlyPrecipitationAcrossStateCapitals == null)
            return false;

        return totalYearlyPrecipitationAcrossStateCapitals == 1799;
    }

    public static boolean adv13(Map<String, Long> numberOfStatesByTimeZone)
    {
        if (numberOfStatesByTimeZone == null)
            return false;

        boolean isMapCorrect = true;

        if (numberOfStatesByTimeZone.get("[Mountain, Pacific]") == null
                || numberOfStatesByTimeZone.get("[Mountain, Pacific]") != 3)
            isMapCorrect = false;
        if (numberOfStatesByTimeZone.get("[Alaska, Hawaii-Aleutian]") == null
                || numberOfStatesByTimeZone.get("[Alaska, Hawaii-Aleutian]") != 1)
            isMapCorrect = false;
        if (numberOfStatesByTimeZone.get("[Eastern]") == null
                || numberOfStatesByTimeZone.get("[Eastern]") != 16)
            isMapCorrect = false;
        if (numberOfStatesByTimeZone.get("[Mountain]") == null
                || numberOfStatesByTimeZone.get("[Mountain]") != 5)
            isMapCorrect = false;
        if (numberOfStatesByTimeZone.get("[Central, Eastern]") == null
                || numberOfStatesByTimeZone.get("[Central, Eastern]") != 6)
            isMapCorrect = false;
        if (numberOfStatesByTimeZone.get("[Central]") == null
                || numberOfStatesByTimeZone.get("[Central]") != 9)
            isMapCorrect = false;
        if (numberOfStatesByTimeZone.get("[Central, Mountain]") == null
                || numberOfStatesByTimeZone.get("[Central, Mountain]") != 7)
            isMapCorrect = false;
        if (numberOfStatesByTimeZone.get("[Pacific]") == null
                || numberOfStatesByTimeZone.get("[Pacific]") != 2)
            isMapCorrect = false;
        if (numberOfStatesByTimeZone.get("[Hawaii-Aleutian]") == null
                || numberOfStatesByTimeZone.get("[Hawaii-Aleutian]") != 1)
            isMapCorrect = false;

        return isMapCorrect;
    }

    public static boolean adv14(Map<String, Long> numberOfStateCapitalsByTimeZone)
    {
        if (numberOfStateCapitalsByTimeZone == null)
            return false;

        boolean isMapCorrect = true;

        if (numberOfStateCapitalsByTimeZone.get("Mountain") == null
                || numberOfStateCapitalsByTimeZone.get("Mountain") != 7)
            isMapCorrect = false;
        if (numberOfStateCapitalsByTimeZone.get("Pacific") == null
                || numberOfStateCapitalsByTimeZone.get("Pacific") != 4)
            isMapCorrect = false;
        if (numberOfStateCapitalsByTimeZone.get("Alaska") == null
                || numberOfStateCapitalsByTimeZone.get("Alaska") != 1)
            isMapCorrect = false;
        if (numberOfStateCapitalsByTimeZone.get("Eastern") == null
                || numberOfStateCapitalsByTimeZone.get("Eastern") != 21)
            isMapCorrect = false;
        if (numberOfStateCapitalsByTimeZone.get("Central") == null
                || numberOfStateCapitalsByTimeZone.get("Central") != 16)
            isMapCorrect = false;
        if (numberOfStateCapitalsByTimeZone.get("Hawaii-Aleutian") == null
                || numberOfStateCapitalsByTimeZone.get("Hawaii-Aleutian") != 1)
            isMapCorrect = false;

        return isMapCorrect;
    }

    public static boolean adv21(List<String> stateTreesSortedAscending)
    {
        if (stateTreesSortedAscending == null)
            return false;

        String expectedStateTrees = "[American elm, American elm, American holly, Black Hills spruce, California redwood, Charter Oak (white oak), Colorado blue spruce, Douglas fir, Norway pine, Sitka spruce, Western Hemlock, Western white pine, bald cypress, buckeye, bur oak, candlenut, eastern cottonwood, eastern hemlock, eastern white pine, eastern white pine, flowering dogwood, flowering dogwood, northern red oak, palo verde, pecan, pine, pine tree, plains cottonwood, plains cottonwood, ponderosa pine, quaking aspen, red maple, redbud, sabal palmetto, sabal palmetto, single-leaf pinyon, southern live oak, southern longleaf pine, southern magnolia, sugar maple, sugar maple, sugar maple, sugar maple, tulip poplar, tulip poplar, tulip tree, two-needle piñon, white birch, white oak, white oak]";
        return expectedStateTrees.equals(stateTreesSortedAscending.toString());
    }

    public static boolean adv22(String allStateNamesSemicolonDelimited)
    {
        if (allStateNamesSemicolonDelimited == null)
            return false;

        String expectedStateNames = "Alabama; Alaska; Arizona; Arkansas; California; Colorado; Connecticut; Delaware; Florida; Georgia; Hawaii; Idaho; Illinois; Indiana; Iowa; Kansas; Kentucky; Louisiana; Maine; Maryland; Massachusetts; Michigan; Minnesota; Mississippi; Missouri; Montana; Nebraska; Nevada; New Hampshire; New Jersey; New Mexico; New York; North Carolina; North Dakota; Ohio; Oklahoma; Oregon; Pennsylvania; Rhode Island; South Carolina; South Dakota; Tennessee; Texas; Utah; Vermont; Virginia; Washington; West Virginia; Wisconsin; Wyoming";
        return expectedStateNames.equals(allStateNamesSemicolonDelimited);
    }

    public static boolean adv23(List<String> allDistinctStateBirds)
    {
        if (allDistinctStateBirds == null)
            return false;

        String expectedStateBirds = "[yellowhammer, willow ptarmigan, cactus wren, mockingbird, California quail, lark bunting, American robin, Delaware blue hen, northern mockingbird, brown thrasher, nene, mountain bluebird, northern cardinal, cardinal, American goldfinch, western meadowlark, brown pelican, black-capped chickadee, Baltimore oriole, common loon, eastern bluebird, purple finch, greater roadrunner, scissor-tailed flycatcher, ruffed grouse, Rhode Island Red, Carolina wren, ring-necked pheasant, California gull, hermit thrush]";
        return expectedStateBirds.equals(allDistinctStateBirds.toString());
    }

    public static boolean adv24(List<String> allDistinctStateBirdsMinusMockingbirds)
    {
        if (allDistinctStateBirdsMinusMockingbirds == null)
            return false;

        String expectedStateBirds = "[yellowhammer, willow ptarmigan, cactus wren, California quail, lark bunting, American robin, Delaware blue hen, brown thrasher, nene, mountain bluebird, northern cardinal, cardinal, American goldfinch, western meadowlark, brown pelican, black-capped chickadee, Baltimore oriole, common loon, eastern bluebird, purple finch, greater roadrunner, scissor-tailed flycatcher, ruffed grouse, Rhode Island Red, Carolina wren, ring-necked pheasant, California gull, hermit thrush]";
        return expectedStateBirds.equals(allDistinctStateBirdsMinusMockingbirds.toString());
    }

    public static boolean adv25(Long numberOfDistinctStateBirds)
    {
        if (numberOfDistinctStateBirds == null)
            return false;

        return numberOfDistinctStateBirds == 30;
    }

    public static boolean adv31(Integer maxStateElevation)
    {
        if (maxStateElevation == null)
            return false;

        return maxStateElevation == 20310;
    }

    public static boolean adv32(LocalDate earliestDateStateEnteredUnion)
    {
        if (earliestDateStateEnteredUnion == null)
            return false;

        return earliestDateStateEnteredUnion.toString().equals("1787-12-07");
    }

    public static boolean adv33(StateInfo stateWithLeastDistanceBetweenHighAndLowPoints)
    {
        if (stateWithLeastDistanceBetweenHighAndLowPoints == null)
            return false;

        return stateWithLeastDistanceBetweenHighAndLowPoints.getStateName().equals("Florida");
    }

    public static boolean adv41(List<String> allStateAndCapitalNames)
    {
        if (allStateAndCapitalNames == null)
            return false;

        String expectedStateAndCapitalNames = "[Alabama, Montgomery, Alaska, Juneau, Arizona, Phoenix, Arkansas, Little Rock, California, Sacramento, Colorado, Denver, Connecticut, Hartford, Delaware, Dover, Florida, Tallahassee, Georgia, Atlanta, Hawaii, Honolulu, Idaho, Boise, Illinois, Springfield, Indiana, Indianapolis, Iowa, Des Moines, Kansas, Topeka, Kentucky, Frankfort, Louisiana, Baton Rouge, Maine, Augusta, Maryland, Annapolis, Massachusetts, Boston, Michigan, Lansing, Minnesota, Saint Paul, Mississippi, Jackson, Missouri, Jefferson City, Montana, Helena, Nebraska, Lincoln, Nevada, Carson City, New Hampshire, Concord, New Jersey, Trenton, New Mexico, Santa Fe, New York, Albany, North Carolina, Raleigh, North Dakota, Bismarck, Ohio, Columbus, Oklahoma, Oklahoma City, Oregon, Salem, Pennsylvania, Harrisburg, Rhode Island, Providence, South Carolina, Columbia, South Dakota, Pierre, Tennessee, Nashville, Texas, Austin, Utah, Salt Lake City, Vermont, Montpelier, Virginia, Richmond, Washington, Olympia, West Virginia, Charleston, Wisconsin, Madison, Wyoming, Cheyenne]";
        return expectedStateAndCapitalNames.equals(allStateAndCapitalNames.toString());
    }

    public static boolean adv42(List<List<String>> allStateAndCapitalNamesTogetherAsLists)
    {
        if (allStateAndCapitalNamesTogetherAsLists == null)
            return false;

        String expectedStateAndCapitalNamesAsLists = "[[Alabama, Montgomery], [Alaska, Juneau], [Arizona, Phoenix], [Arkansas, Little Rock], [California, Sacramento], [Colorado, Denver], [Connecticut, Hartford], [Delaware, Dover], [Florida, Tallahassee], [Georgia, Atlanta], [Hawaii, Honolulu], [Idaho, Boise], [Illinois, Springfield], [Indiana, Indianapolis], [Iowa, Des Moines], [Kansas, Topeka], [Kentucky, Frankfort], [Louisiana, Baton Rouge], [Maine, Augusta], [Maryland, Annapolis], [Massachusetts, Boston], [Michigan, Lansing], [Minnesota, Saint Paul], [Mississippi, Jackson], [Missouri, Jefferson City], [Montana, Helena], [Nebraska, Lincoln], [Nevada, Carson City], [New Hampshire, Concord], [New Jersey, Trenton], [New Mexico, Santa Fe], [New York, Albany], [North Carolina, Raleigh], [North Dakota, Bismarck], [Ohio, Columbus], [Oklahoma, Oklahoma City], [Oregon, Salem], [Pennsylvania, Harrisburg], [Rhode Island, Providence], [South Carolina, Columbia], [South Dakota, Pierre], [Tennessee, Nashville], [Texas, Austin], [Utah, Salt Lake City], [Vermont, Montpelier], [Virginia, Richmond], [Washington, Olympia], [West Virginia, Charleston], [Wisconsin, Madison], [Wyoming, Cheyenne]]";
        return expectedStateAndCapitalNamesAsLists.equals(allStateAndCapitalNamesTogetherAsLists.toString());
    }

    public static boolean adv43(Map<String, String> stateNameToCapitalNamesMap)
    {
        if (stateNameToCapitalNamesMap == null)
            return false;

        boolean isMapCorrect = true;

        if (stateNameToCapitalNamesMap.get("North Carolina") == null
                || !stateNameToCapitalNamesMap.get("North Carolina").equals("Raleigh"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Indiana") == null
                || !stateNameToCapitalNamesMap.get("Indiana").equals("Indianapolis"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Wyoming") == null
                || !stateNameToCapitalNamesMap.get("Wyoming").equals("Cheyenne"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Utah") == null
                || !stateNameToCapitalNamesMap.get("Utah").equals("Salt Lake City"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Arizona") == null
                || !stateNameToCapitalNamesMap.get("Arizona").equals("Phoenix"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Montana") == null
                || !stateNameToCapitalNamesMap.get("Montana").equals("Helena"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Kentucky") == null
                || !stateNameToCapitalNamesMap.get("Kentucky").equals("Frankfort"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("California") == null
                || !stateNameToCapitalNamesMap.get("California").equals("Sacramento"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Kansas") == null
                || !stateNameToCapitalNamesMap.get("Kansas").equals("Topeka"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Delaware") == null
                || !stateNameToCapitalNamesMap.get("Delaware").equals("Dover"))
            isMapCorrect = false;

        // 10 done

        if (stateNameToCapitalNamesMap.get("Florida") == null
                || !stateNameToCapitalNamesMap.get("Florida").equals("Tallahassee"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Pennsylvania") == null
                || !stateNameToCapitalNamesMap.get("Pennsylvania").equals("Harrisburg"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Iowa") == null
                || !stateNameToCapitalNamesMap.get("Iowa").equals("Des Moines"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Mississippi") == null
                || !stateNameToCapitalNamesMap.get("Mississippi").equals("Jackson"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Illinois") == null
                || !stateNameToCapitalNamesMap.get("Illinois").equals("Springfield"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Texas") == null
                || !stateNameToCapitalNamesMap.get("Texas").equals("Austin"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Connecticut") == null
                || !stateNameToCapitalNamesMap.get("Connecticut").equals("Hartford"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Georgia") == null
                || !stateNameToCapitalNamesMap.get("Georgia").equals("Atlanta"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Maryland") == null
                || !stateNameToCapitalNamesMap.get("Maryland").equals("Annapolis"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Virginia") == null
                || !stateNameToCapitalNamesMap.get("Virginia").equals("Richmond"))
            isMapCorrect = false;

        // 20 done

        if (stateNameToCapitalNamesMap.get("Idaho") == null
                || !stateNameToCapitalNamesMap.get("Idaho").equals("Boise"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Oregon") == null
                || !stateNameToCapitalNamesMap.get("Oregon").equals("Salem"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Vermont") == null
                || !stateNameToCapitalNamesMap.get("Vermont").equals("Montpelier"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Maine") == null
                || !stateNameToCapitalNamesMap.get("Maine").equals("Augusta"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Oklahoma") == null
                || !stateNameToCapitalNamesMap.get("Oklahoma").equals("Oklahoma City"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Tennessee") == null
                || !stateNameToCapitalNamesMap.get("Tennessee").equals("Nashville"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Alabama") == null
                || !stateNameToCapitalNamesMap.get("Alabama").equals("Montgomery"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Arkansas") == null
                || !stateNameToCapitalNamesMap.get("Arkansas").equals("Little Rock"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("South Carolina") == null
                || !stateNameToCapitalNamesMap.get("South Carolina").equals("Columbia"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Washington") == null
                || !stateNameToCapitalNamesMap.get("Washington").equals("Olympia"))
            isMapCorrect = false;

         // 30 done

        if (stateNameToCapitalNamesMap.get("Nebraska") == null
                || !stateNameToCapitalNamesMap.get("Nebraska").equals("Lincoln"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("West Virginia") == null
                || !stateNameToCapitalNamesMap.get("West Virginia").equals("Charleston"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Colorado") == null
                || !stateNameToCapitalNamesMap.get("Colorado").equals("Denver"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Massachusetts") == null
                || !stateNameToCapitalNamesMap.get("Massachusetts").equals("Boston"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Missouri") == null
                || !stateNameToCapitalNamesMap.get("Missouri").equals("Jefferson City"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Alaska") == null
                || !stateNameToCapitalNamesMap.get("Alaska").equals("Juneau"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("North Dakota") == null
                || !stateNameToCapitalNamesMap.get("North Dakota").equals("Bismarck"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Wisconsin") == null
                || !stateNameToCapitalNamesMap.get("Wisconsin").equals("Madison"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Nevada") == null
                || !stateNameToCapitalNamesMap.get("Nevada").equals("Carson City"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("New York") == null
                || !stateNameToCapitalNamesMap.get("New York").equals("Albany"))
            isMapCorrect = false;

        // 40 done

        if (stateNameToCapitalNamesMap.get("Rhode Island") == null
                || !stateNameToCapitalNamesMap.get("Rhode Island").equals("Providence"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Hawaii") == null
                || !stateNameToCapitalNamesMap.get("Hawaii").equals("Honolulu"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("South Dakota") == null
                || !stateNameToCapitalNamesMap.get("South Dakota").equals("Pierre"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Minnesota") == null
                || !stateNameToCapitalNamesMap.get("Minnesota").equals("Saint Paul"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("New Jersey") == null
                || !stateNameToCapitalNamesMap.get("New Jersey").equals("Trenton"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Michigan") == null
                || !stateNameToCapitalNamesMap.get("Michigan").equals("Lansing"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("New Mexico") == null
                || !stateNameToCapitalNamesMap.get("New Mexico").equals("Santa Fe"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("New Hampshire") == null
                || !stateNameToCapitalNamesMap.get("New Hampshire").equals("Concord"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Louisiana") == null
                || !stateNameToCapitalNamesMap.get("Louisiana").equals("Baton Rouge"))
            isMapCorrect = false;
        if (stateNameToCapitalNamesMap.get("Ohio") == null
                || !stateNameToCapitalNamesMap.get("Ohio").equals("Columbus"))
            isMapCorrect = false;

        // 50 done!

        return isMapCorrect;
    }

    public static boolean expert1(List<String> allDenonymsThatDoNotContainStateName)
    {
        if (allDenonymsThatDoNotContainStateName == null)
            return false;

        String expectedDenonymsThatDoNotContainStateName = "[Alabamian, Arkansan, Arkansawyer, Arkanite, Coloradan, Nutmegger, Floridian, Hoosier, Kansan, Jayhawker, Kentuckian, Louisianian, Bay Stater, Massachusite, Yooper, Granite Stater, New Hampshirite, New Mexican, North Carolinian, Tar Heel, Buckeye, Okie, South Carolinian, Tennessean, Texan, Mountaineer]";
        return expectedDenonymsThatDoNotContainStateName.equals(allDenonymsThatDoNotContainStateName.toString());
    }

    public static boolean expert2(Long totalNumberOfHonoluluSisterCitiesStartingWithCa)
    {
        if (totalNumberOfHonoluluSisterCitiesStartingWithCa == null)
            return false;

        return totalNumberOfHonoluluSisterCitiesStartingWithCa == 3;
    }

    public static boolean expert3(List<String> countriesOfTheWorldWithNoUSCapitalSisterCities)
    {
        // If you need hints:
        // 1. replaceAll(".*, ", "") is a pretty cool way to chop off the city from the sisterCities lists
        // 2. You can negate the important contains() with a well-placed "!"

        if (countriesOfTheWorldWithNoUSCapitalSisterCities == null)
            return false;

        String expectedCountriesOfTheWorldWithNoUSCapitalSisterCities = "[Afghanistan, Åland Islands, Albania, Algeria, American Samoa, Andorra, Angola, Anguilla, Antarctica, Antigua and Barbuda, Armenia, Aruba, Austria, Bahrain, Bangladesh, Barbados, Belarus, Belize, Bermuda, Bhutan, Bolivia (Plurinational State of), Bonaire and Sint Eustatius and Saba, Bosnia and Herzegovina, Botswana, Bouvet Island, British Indian Ocean Territory, United States Minor Outlying Islands, Virgin Islands (British), Virgin Islands (U.S.), Brunei Darussalam, Burkina Faso, Burundi, Cambodia, Cameroon, Cabo Verde, Cayman Islands, Central African Republic, Chad, Chile, Christmas Island, Cocos (Keeling) Islands, Comoros, Congo, Congo (Democratic Republic of the), Cook Islands, Costa Rica, Croatia, Curaçao, Cyprus, Dominica, Ecuador, Equatorial Guinea, Eritrea, Falkland Islands (Malvinas), Faroe Islands, Fiji, Finland, French Guiana, French Polynesia, French Southern Territories, Gabon, Gibraltar, Greenland, Grenada, Guadeloupe, Guam, Guernsey, Guinea, Guinea-Bissau, Guyana, Heard Island and McDonald Islands, Holy See, Honduras, Hong Kong, Hungary, Iceland, Indonesia, Côte d'Ivoire, Iran (Islamic Republic of), Iraq, Isle of Man, Jordan, Kazakhstan, Kiribati, Kuwait, Kyrgyzstan, Lao People's Democratic Republic, Latvia, Lebanon, Liberia, Libya, Liechtenstein, Luxembourg, Macao, Macedonia (the former Yugoslav Republic of), Madagascar, Malawi, Maldives, Malta, Martinique, Mauritania, Mauritius, Mayotte, Micronesia (Federated States of), Moldova (Republic of), Monaco, Montenegro, Montserrat, Myanmar, Nauru, Nepal, New Caledonia, Niger, Niue, Norfolk Island, Korea (Democratic People's Republic of), Northern Mariana Islands, Norway, Oman, Pakistan, Palau, Palestine (State of), Panama, Papua New Guinea, Paraguay, Pitcairn, Poland, Qatar, Republic of Kosovo, Réunion, Russian Federation, Saint Barthélemy, Saint Helena and Ascension and Tristan da Cunha, Saint Kitts and Nevis, Saint Lucia, Saint Martin (French part), Saint Pierre and Miquelon, Saint Vincent and the Grenadines, Samoa, San Marino, Sao Tome and Principe, Saudi Arabia, Serbia, Seychelles, Sierra Leone, Singapore, Sint Maarten (Dutch part), Solomon Islands, South Georgia and the South Sandwich Islands, Korea (Republic of), South Sudan, Sri Lanka, Sudan, Suriname, Svalbard and Jan Mayen, Swaziland, Syrian Arab Republic, Tanzania (United Republic of), Thailand, Timor-Leste, Togo, Tokelau, Tonga, Turkmenistan, Turks and Caicos Islands, Tuvalu, Uganda, United Arab Emirates, United Kingdom of Great Britain and Northern Ireland, United States of America, Uruguay, Vanuatu, Venezuela (Bolivarian Republic of), Viet Nam, Wallis and Futuna, Western Sahara, Yemen, Zimbabwe]";
        return expectedCountriesOfTheWorldWithNoUSCapitalSisterCities
                .equals(countriesOfTheWorldWithNoUSCapitalSisterCities.toString());
    }

    public static boolean expert4(String statesWithLargestDifferenceBetweenHighestElevations)
    {
        if (statesWithLargestDifferenceBetweenHighestElevations == null)
            return false;

        if (statesWithLargestDifferenceBetweenHighestElevations.equals("Colorado Kansas")
                || statesWithLargestDifferenceBetweenHighestElevations.equals("Kansas Colorado"))
        {
            return true;
        }

        return false;
    }

    public static boolean expert5(String closestStateCapitals)
    {
        if (closestStateCapitals == null)
            return false;

        if (closestStateCapitals.equals("Boston Providence")
                || closestStateCapitals.equals("Providence Boston"))
        {
            return true;
        }

        return false;
    }
}
