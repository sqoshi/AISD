//
// Created by piotr on 12.03.19.
//
#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int value;
    struct Node* next;
} Node;
typedef struct List {

    unsigned int size;
    Node* head;
} List;

void InitList(List* list){
    list->head=NULL;
    list->size=0;
}

void printList(List* list) {
    Node* node = list->head;

    while(node != NULL) {
        int d = node->value;
        printf("%d -> ", d);

        node = node->next;
    }

    printf("NULL\n");
}
int isempty(List* list) {
    if (list->head == NULL) return 1;
    return 0;
}

int Insert(List* list, int value) {
    Node* Tmp=NULL;
    Node* End=NULL;
    Node* New=NULL;

    if (!list) return 0;

    Tmp=End=list->head;

    while(Tmp){
        if(Tmp->value==value) break;
        End=Tmp;
        Tmp=Tmp->next;
    }

    New=(Node*)malloc(sizeof(Node));
    if(!New) return 0;

    New->next=NULL;
    New->value=value;
    ++(list->size);

    if(!End){
        list->head=New;
        return 1;
    }
    End->next=New;
    return 1;
}

int delete(List* list, int value){
    Node* current=list->head;
    Node* previous= NULL;
    while(current!=NULL){

    }
}
