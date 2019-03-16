//
// Created by piotr on 12.03.19.
//

#ifndef LIST1_LINKEDLIST_H
#define LIST1_LINKEDLIST_H
/**
 * Struct with pointer to next node
 * and key
 */
typedef struct Node {
    int value;
    struct Node *next;
} Node;

/**
 * Head od the LinkedList
 */
typedef struct List {

    unsigned int size;
    Node *head;
} List;
/**
 * Initing LinkedList
 * @param list
 * @return 1 if positive 0 if negative
 */
void InitList(List *list);
/**
 * Printing Keys
 * @param list
 * @return 1 if positive 0 if negative
 */
void printList(struct List *list);
/**
 * Checking if any key is on the list
 * @param list
 * @return 1 if empty else 0
 */
int isEmpty(List *list);
/**
 * Inserting Key into list
 * @param list
 * @param value
 * @return 1 if added succesfully, else 0
 */
int Insert(List *list, int value);
/**
 * Deleting Key from the list
 * @param list
 * @param value
 * @return 1 if deleted succesfully, else 0
 */
int delete(List *list, int value);
/**
 * Finding element and moving it to the head.
 * @param list
 * @param value
 * @return 1 if key were find and moved succesfully, else 0
 */
int findMTF(List *list, int value);
/**
 * Finding element and transpositioning it with previous node.
 * @param list
 * @param value
 * @return 1 if key were find and moved succesfully, else 0
 */
int findTRANS(List *list, int value);

#endif //LIST1_LINKEDLIST_H
