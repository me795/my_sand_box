package com.company;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	static Long	startTime;
	static Long endTime;

	static final String ANSI_RESET = "\u001B[0m";
	static final String ANSI_BLUE = "\u001B[34m";
	static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {

		System.out.print("Укажите количество элементов в массиве для эксперимента: ");
		int numberOfElements = inputNumberOfElements();
		System.out.println();
		System.out.println();
		ArrayList<Integer> baseArrayList = generateList(numberOfElements);

		ArrayList<Integer> firstArrayList = (ArrayList<Integer>) baseArrayList.clone();
		ArrayList<Integer> secondArrayList = (ArrayList<Integer>) baseArrayList.clone();
		ArrayList<Integer> thirdArrayList = (ArrayList<Integer>) baseArrayList.clone();

		referenceExperiment(baseArrayList);
		firstExperiment(firstArrayList);
		secondExperiment(secondArrayList);
		thirdExperiment(thirdArrayList);

    }

	private static ArrayList<Integer> generateList(int numberOfElements){

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < numberOfElements; i++){
			list.add(getRandomInt());
		}

		return list;
	}

	private static Integer getRandomInt(){
    	return ThreadLocalRandom.current().nextInt(-32768, 32768);
	}

	private static void referenceExperiment(ArrayList<Integer> list){

		System.out.println(ANSI_BLUE + "Эталонная сортировка Java" + ANSI_RESET);
		printList(list, "Исходный список: ");

		startTime = printTimeAndGetIt("Время начала эксперимента: ");

		list.sort(Comparator.naturalOrder());
		printList(list, "Результат: ");

		endTime = printTimeAndGetIt("Время окончания эксперимента: ");
		printDuration(startTime, endTime);
	}



	private static void firstExperiment(ArrayList<Integer> list){

		System.out.println(ANSI_BLUE + "Эксперимент №1. Сортировка выбором" + ANSI_RESET);
		printList(list, "Исходный список: ");

		startTime = printTimeAndGetIt("Время начала эксперимента: ");

		selectionSort(list);
		printList(list, "Результат: ");

		endTime = printTimeAndGetIt("Время окончания эксперимента: ");
		printDuration(startTime, endTime);

	}

	private static void secondExperiment(ArrayList<Integer> list){

		System.out.println(ANSI_BLUE + "Эксперимент №2. Пузырьковая сортировка" + ANSI_RESET);
		printList(list, "Исходный список: ");

		startTime = printTimeAndGetIt("Время начала эксперимента: ");

		bubbleSort(list);
		printList(list, "Результат: ");

		endTime = printTimeAndGetIt("Время окончания эксперимента: ");
		printDuration(startTime, endTime);

	}

	private static void thirdExperiment(ArrayList<Integer> list){

		System.out.println(ANSI_BLUE + "Эксперимент №3. Собственный вариант" + ANSI_RESET);
		printList(list, "Исходный список: ");

		startTime = printTimeAndGetIt("Время начала эксперимента: ");

		mySort(list);
		printList(list, "Результат: ");

		endTime = printTimeAndGetIt("Время окончания эксперимента: ");
		printDuration(startTime, endTime);

	}

	private static void selectionSort(ArrayList<Integer> list){

    	int min;
		int nMin;

    	for (int i = 0; i < list.size() - 1; i++){

    		min = list.get(i);
    		nMin = i;

			for (int j = i + 1; j < list.size(); j++){
				if (list.get(j) < min){
					min = list.get(j);
					nMin = j;
				}
			}

			if (nMin != i) {
				Collections.swap(list, i, nMin);
			}
		}
	}

	private static void bubbleSort(ArrayList<Integer> list){

		for (int i = list.size() - 1; i > 0; i--){
			for (int j = 0; j < i; j++){
				if (list.get(i) < list.get(j)){
					Collections.swap(list, i, j);
				}
			}
		}
	}

	/*
	По сути это доработка "Сортировки выбором" с поиском минимального и максимального значения в один проход.
	Таким образом можно сэкономить около половины времени от изначального варианта.
	 */
	private static void mySort(ArrayList<Integer> list){

    	int reminder = list.size();
    	int offset = 0;
    	int min;
		int max;
		int nMin;
		int nMax;

		do{

			min = max = list.get(offset);
			nMin = nMax = offset;
			for (int i = offset; i < list.size() - offset; i++){

				if (list.get(i) <= min){
					min = list.get(i);
					nMin = i;
				}else if (list.get(i) >= max){
					max = list.get(i);
					nMax = i;
				}
			}

			if (nMin != offset)
				Collections.swap(list, nMin, offset);
			if (nMax != list.size() - offset - 1)
				Collections.swap(list, nMax, list.size() - offset - 1);

			reminder = reminder - 2;
			offset++;

		}while (reminder > 1);

	}


	private static void printList(ArrayList<Integer> list, String s) {
		System.out.println(s);
//		System.out.println(list);
	}

	private static long printTimeAndGetIt(String message) {
		Date date;
		long time;
		String timeStamp;
		date = new Date();
		time = date.getTime();
		timeStamp = new SimpleDateFormat("HH:mm:ss.SSSSSS").format(time);
		System.out.println(message + timeStamp);
		return time;
	}

	private static void printDuration(long startTime, long endTime) {
		long duration;
		duration = endTime - startTime;
		System.out.println("Продолжительность эксперимента в миллисекундах: " + duration);
		System.out.println();
		System.out.println();
	}

	private static int inputNumberOfElements() {


		Scanner sc = new Scanner(System.in);
		String userInput;

		boolean is_digital = false;
		do {
			userInput = sc.nextLine();
			if (userInput.matches("[-+]?\\d+")) {
				is_digital = true;
			}else {
				System.out.println(ANSI_RED + "Пожалуйста, введите число" + ANSI_RESET);
			}
		} while (!is_digital);

		return Integer.parseInt(userInput);
	}
}
