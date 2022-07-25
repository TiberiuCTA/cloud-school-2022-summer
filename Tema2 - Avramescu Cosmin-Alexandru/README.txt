

    Am facut 2 semfoare si cate un thread pentru fiecare semafor. Avand in vedere ca tema este o intersectie, mi se
pare mai natural sa existe un thread pentru fiecare semafor deoarece toate masinile oprite la acel semafor trebuie
sa treaca pe rand prin intersectie, nu in acelasi timp. Am implementat interfata Runnable (metoda run) si am creat in
main cele 2 threaduri.
    M-am folosit de LinkedList pentru a stoca masinile stationate la fiecare semafor deoarece e mai eficient
decat un Array la stergere (dupa ce trec prin intersectie masinile, le sterg din lista). Cat timp inca mai
sunt masini care trebuie sa treaca prin intersectie, pornesc thread1 (corespunzator semaforului 1) si astept
pana toate acele masini trec intersectia (thread1.join()). Abia acum pornesc thread2 pentru a trece masinile de pe
directia perpendiculara. Se poate da start o singura data la threaduri, asa ca daca cele 2 threaduri au statusul
"terminated", atunci reinstantiezi cele 2 threaduri cu new pentru a le putea da start la urmatoarea trecere de masini
prin intersectie.
    In metoda run(), daca semaforul 1 are permits = 1, inseamna ca el este pe verde, iar semaforul 2 este pe rosu.
Acquire() face permits=0 si release() face permits=1. Dau acquire() la semaforul 1 si release() la semaforul 2
deoarece dupa ce trec masinile de la semaforul 1, trebuie sa treaca masinile de la semaforul 2. In functia cross()
masinile trec intersectia efectiv (max_cars_crossing este 3) si sunt sterse dupa trecere.
    La fiecare afisare arat ce masina trece, pe ce directie si ce thread s-a ocupat de trecerea ei. Am folosit un
identificator 'a' sau 'b' in clasa Car pentru a fi mai clara afisarea (masina 1a e de pe N-S, masina 1b e de pe W-E).
