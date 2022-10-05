import ballerina/io;

public function main() {
    io:println("Hello, World!");
}

public function intAdd(int a, int b) returns (int) {
    return a + b;
}
