import ballerina/test;

@test:Config {}
function intAddTest() {
    test:assertEquals(intAdd(1, 3), 4);
}
