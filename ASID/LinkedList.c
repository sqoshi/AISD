//
// Created by piotr on 12.03.19.
//
#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"


int MTFcount = 0;
int TRANScount = 0;

List list;

void InitList(List *list) {
    list->head = NULL;
    list->size = 0;
}

void printList(List *list) {
    Node *node = list->head;

    while (node != NULL) {
        int d = node->value;
        printf("%d -> ", d);

        node = node->next;
    }

    printf("NULL\n");
}

int isEmpty(List *list) {
    if (list->head == NULL) return 1;
    return 0;
}

int Insert(List *list, int value) {
    Node *Tmp = NULL;
    Node *End = NULL;
    Node *New = NULL;

    if (!list) return 0;

    Tmp = End = list->head;

    while (Tmp) {
        if (Tmp->value == value) break;
        End = Tmp;
        Tmp = Tmp->next;
    }

    New = (Node *) malloc(sizeof(Node));
    if (!New) return 0;

    New->next = NULL;
    New->value = value;
    ++(list->size);

    if (!End) {
        list->head = New;
        return 1;
    }
    End->next = New;
    return 1;
}

int delete(List *list, int value) {
    Node *current = list->head;
    Node *previous = NULL;
    while (current != NULL) {
        if (current->value == value) {
            if (previous != NULL) {
                previous->next = current->next;
            } else {
                list->head = current->next;
            }
            free(current);
            return 1;
        }
        previous = current;
        current = current->next;
    }
    return 0;
}

int findMTF(List *list, int value) {
    Node *current = list->head;
    Node *previous = NULL;
    while (current != NULL) {
        MTFcount++;
        if (current->value == value) {
            if (previous != NULL) {
                previous->next = current->next;
                current->next = list->head;
                list->head = current;
            }
        }
        previous = current;
        current = current->next;
    }
}

int findTRANS(List *list, int value) {
    Node *current = list->head;
    Node *previous = NULL;
    Node *preprevious = NULL;
    while (current != NULL) {
        TRANScount++;
        if (current->value == value) {
            if (previous != NULL) {
                if (preprevious != NULL) {
                    preprevious->next = current;
                    previous->next = current->next;
                    current->next = previous;
                } else {
                    list->head = current;
                    previous->next = current->next;
                    current->next;
                }
            }
        }
        preprevious = previous;
        previous = current;
        current = current->next;
    }
    return 0;
}

int main(void) {
    List list;
    InitList(&list);
    Insert(&list, 7);
    Insert(&list, 8);
    Insert(&list, 79);
    Insert(&list, 71);
    printList(&list);
    List list1;
    delete(&list, 79);
    findTRANS(&list, 71);
    printList(&list);
    printf("********************\n");
    InitList(&list1);
    Insert(&list1, 7);
    Insert(&list1, 8);
    Insert(&list1, 79);
    Insert(&list1, 71);
    printList(&list1);
    findMTF(&list1, 79);
    printList(&list1);
    return 0;
}

