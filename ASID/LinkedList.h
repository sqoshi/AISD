//
// Created by piotr on 12.03.19.
//

#ifndef LIST1_LINKEDLIST_H
#define LIST1_LINKEDLIST_H

typedef struct Node {
    int value;
    struct Node *next;
} Node;
typedef struct List {

    unsigned int size;
    Node *head;
} List;

void InitList(List *list);
void printList(List *list);
int isempty(List *list);
int Insert(List *list, int value);
int delete(List *list, int value);
int findMTF(List *list, int value);
int findTRANS(List *list, int value);
#endif //LIST1_LINKEDLIST_H
