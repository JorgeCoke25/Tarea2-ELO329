JFLAGS = -g
JC = javac
JVM = java
JAVAFX = --module-path /home/coke/Downloads/openjfx-18.0.1_linux-x64_bin-sdk/javafx-sdk-18.0.1/lib --add-modules javafx.controls

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $(JAVAFX) *.java

CLASSES = \
	Stage1.java \
	Cloud.java \
	Lamp.java \
	LampControl.java \
	LampControlView.java \
	LampView.java\
	LampState.java 

MAIN = Stage1

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
		$(JVM) $(JAVAFX) $(MAIN)
clean:
	$(RM) *.class