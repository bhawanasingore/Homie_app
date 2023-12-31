package com.google.firebase.database.snapshot;

import com.google.firebase.database.core.Path;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-database@@19.3.0 */
public interface Node extends Comparable<Node>, Iterable<NamedNode> {
    public static final ChildrenNode MAX_NODE = new ChildrenNode() {
        public int compareTo(Node other) {
            return other == this ? 0 : 1;
        }

        public boolean equals(Object other) {
            return other == this;
        }

        public Node getPriority() {
            return this;
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean hasChild(ChildKey childKey) {
            return false;
        }

        public Node getImmediateChild(ChildKey name) {
            if (name.isPriorityChildName()) {
                return getPriority();
            }
            return EmptyNode.Empty();
        }

        public String toString() {
            return "<Max Node>";
        }
    };

    /* compiled from: com.google.firebase:firebase-database@@19.3.0 */
    public enum HashVersion {
        V1,
        V2
    }

    Node getChild(Path path);

    int getChildCount();

    String getHash();

    String getHashRepresentation(HashVersion hashVersion);

    Node getImmediateChild(ChildKey childKey);

    ChildKey getPredecessorChildKey(ChildKey childKey);

    Node getPriority();

    ChildKey getSuccessorChildKey(ChildKey childKey);

    Object getValue();

    Object getValue(boolean z);

    boolean hasChild(ChildKey childKey);

    boolean isEmpty();

    boolean isLeafNode();

    Iterator<NamedNode> reverseIterator();

    Node updateChild(Path path, Node node);

    Node updateImmediateChild(ChildKey childKey, Node node);

    Node updatePriority(Node node);
}
