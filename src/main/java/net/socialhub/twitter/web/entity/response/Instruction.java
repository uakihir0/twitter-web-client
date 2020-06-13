package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

/**
 * Instruction
 * Only one field is non-null.
 */
public class Instruction {

    @SerializedName("addEntries")
    private EntriesRef addEntries;
    @SerializedName("pinEntry")
    private EntryRef pinEntry;

    // region
    public EntriesRef getAddEntries() {
        return addEntries;
    }

    public EntryRef getPinEntry() {
        return pinEntry;
    }
    // endregion

    public static class EntryRef {

        @SerializedName("entry")
        private Entry entry;

        // region
        public Entry getEntry() {
            return entry;
        }
        // endregion
    }

    public static class EntriesRef {
        
        @SerializedName("entries")
        private Entry[] entries;

        // region
        public Entry[] getEntries() {
            return entries;
        }
        // endregion
    }

}
