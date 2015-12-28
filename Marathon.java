class Marathon {
    private static int indexFastest(int[] times, int nthElement) {
        int index;
        int[] tempTimes = times.clone();
        HashMap timesIndex = new HashMap<Integer, Integer>(tempTimes.length);

        for (int i = 0; i < tempTimes.length; i++) {
            timesIndex.put(tempTimes[i], i);
        }

        Arrays.sort(tempTimes);
        index = (int)timesIndex.get(tempTimes[nthElement]);
        return index;
    }

    public static void main (String[] arguments) {
        String[] names = {
            "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
            "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
            "Aaron", "Kate"
        };

        int[] times = {
            341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
            343, 317, 265
        };

        int index = indexFastest(times, 0);
        System.out.println(names[index] + ": " + times[index]);

        int secondIndex = indexFastest(times, 1);
        System.out.println(names[secondIndex] + ": " + times[secondIndex]);
    }
}
