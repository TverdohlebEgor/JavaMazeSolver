javac -d . $(find . -name "*.java")

if (( $? != 0 ));then
	return 1
fi

java MazeSolver.Main
