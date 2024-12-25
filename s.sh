find . -name "*.java" | grep -v "main" > sources.txt

while read line;do
	javac -d . $line
	if (( $? != 0 ));then
		return 1
	fi
done < sources.txt

rm sources.txt
javac -d . Main.java 

if (( $? != 0 ));then
	return 1
fi

java MazeSolver.Main
