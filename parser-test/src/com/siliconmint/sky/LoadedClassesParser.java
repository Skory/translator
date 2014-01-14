package com.siliconmint.sky;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadedClassesParser {

    private static final Pattern CLASS_LOAD_LOG_PATTERN = Pattern.compile("^\\[Loaded (.*) from (.*)\\]$");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("parser-test/loaded_classes.txt"));

        Set<String> classSources = new TreeSet<String>();
        Set<String> packages = new TreeSet<String>();
        Multimap<String, String> loadedPackages = ArrayListMultimap.create();
        Multimap<String, String> loadedPackageClasses = ArrayListMultimap.create();
        Multimap<String, String> packagesBySource = ArrayListMultimap.create();

        String str;

        while ( (str = br.readLine()) != null ) {
            Matcher matcher = CLASS_LOAD_LOG_PATTERN.matcher(str);
            if (matcher.matches()) {
                String loadedClass = matcher.group(1);
                String source = matcher.group(2);

                String packageName;
                String className;
                int dotIndex = loadedClass.lastIndexOf('.');
                if (dotIndex != -1) {
                    packageName = loadedClass.substring(0, dotIndex);
                    className = loadedClass.substring(dotIndex);
                } else {
                    // Default package
                    packageName = "<default>";
                    className = loadedClass;
                }

                classSources.add(source);
                packages.add(packageName);
                loadedPackages.put(packageName, source);
                loadedPackageClasses.put(packageName, className);
                packagesBySource.put(source, packageName);
            } else {
                System.out.println("Unable to parse: " + str);
            }
        }

        printSources(classSources);

        printPackages(packages);

        printPackageSources(packages, loadedPackages);

        printPackagesBySource(classSources, packagesBySource);
    }

    private static void printSources(Set<String> classSources) {
        System.out.println("Class sources:");
        for (String source: classSources) {
            System.out.println('\t' + source);
        }
        System.out.println();
    }

    private static void printPackages(Set<String> packages) {
        System.out.println("IntelliJ Packages:");
        for (String packageName: packages) {
            if (!packageName.startsWith("com.intellij")) continue;

            System.out.println('\t' + packageName);
        }
        System.out.println();
    }

    private static void printPackageSources(Set<String> packages, Multimap<String, String> loadedPackages) {
        System.out.println("IntelliJ Packages sources:");
        for (String packageName: packages) {
            if (!packageName.startsWith("com.intellij")) continue;

            System.out.println('\t' + packageName);
            for (String source: new TreeSet<String>(loadedPackages.get(packageName))) {
                System.out.println("\t\t" + source);
            }
        }
        System.out.println();
    }

    private static void printPackagesBySource(Set<String> classSources, Multimap<String, String> packagesBySource) {
        System.out.println("IntelliJ Packages by source:");
        for (String source: classSources) {

            System.out.println('\t' + source);
            for (String packageName: new TreeSet<String>(packagesBySource.get(source))) {
                System.out.println("\t\t" + packageName);
            }
        }
        System.out.println();
    }

}
