package com.javarush.test.NetCraker.CollectionsTasks;

import java.util.*;

/**
 * Created by Аркадий on 14.11.2015.
 */
public class StringFilterImpl implements StringFilter
{
    private Set<String> set = new HashSet<>();

    @Override
    public void add(String s)
    {
        if(s == null) {
            set.add(null);
        } else {
            set.add(s.toLowerCase());
        }
    }

    @Override
    public boolean remove(String s)
    {
        if(s == null) {
            return set.remove(null);
        } else {
            return set.remove(s.toLowerCase());
        }
    }

    @Override
    public void removeAll()
    {
        set.clear();
    }

    @Override
    public Collection<String> getCollection()
    {
        return set;
    }

    @Override
    public Iterator<String> getStringsContaining(final String chars)
    {
        Filter filter = new Filter() {
            public boolean isRightString(String s) {
                if(chars == null || chars.isEmpty()) {
                    return true;
                }
                if(s == null) {
                    return false;
                }
                return s.contains(chars.toLowerCase());
            }
        };
        return getRightStrings(filter);
    }

    @Override
    public Iterator<String> getStringsStartingWith(final String begin)
    {
        Filter filter = new Filter() {
            public boolean isRightString(String s) {
                if(begin == null || begin.isEmpty()) {
                    return true;
                }
                if(s == null) {
                    return false;
                }
                return s.startsWith(begin.toLowerCase());
            }
        };
        return getRightStrings(filter);
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(final String format)
    {
        Filter filter = new Filter() {
            public boolean isRightString(String s) {
                if(format == null || format.isEmpty()) {
                    return true;
                } else if(s == null) {
                    return false;
                } else if(format.length() != s.length()) {
                    return false;
                } else {
                    for(int i = 0; i < format.length(); i++) {
                        if(format.charAt(i) == '#') {
                            if(s.charAt(i) < '0' || s.charAt(i) > '9') {
                                return false;
                            }
                        } else {
                            if(format.charAt(i) != s.charAt(i)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        };
        return getRightStrings(filter);
    }

    @Override
    public Iterator<String> getStringsByPattern(final String pattern)
    {
        Filter filter = new Filter() {
            public boolean isRightString(String s) {
                if(pattern == null || pattern.isEmpty()) {
                    return true;
                }
                if(s == null) {
                    return false;
                }
                List<String> list = new ArrayList<>();
                String temp = pattern;
                int index;
                while((index = temp.indexOf("*")) != -1) {
                    list.add(temp.substring(0, index));
                    temp = temp.substring(index + 1);
                }
                list.add(temp);
                for(int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if(i == 0) {
                        if(!s.startsWith(str)) {
                            return false;
                        }
                        s = s.substring(s.indexOf(str) + str.length());
                    } else if(i == list.size() - 1) {
                        if(!s.endsWith(str)) {
                            return false;
                        }
                        s = s.substring(s.indexOf(str) + str.length());
                        if(!s.isEmpty() && !str.isEmpty()) {
                            return pattern.charAt(pattern.lastIndexOf(str) - 1) == '*';
                        }
                    } else if(s.contains(str)) {
                        s = s.substring(s.indexOf(str) + str.length());
                    } else {
                        return false;
                    }
                }
                return !(!s.isEmpty() && pattern.charAt(pattern.length() - 1) != '*');
            }
        };
        return getRightStrings(filter);
    }

    private interface Filter
    {
        boolean isRightString(String s);
    }

    private Iterator<String> getRightStrings(Filter filter)
    {
        Set<String> result  = new HashSet<>();
        for(String s: set) {
            if(filter.isRightString(s)) {
                result.add(s);
            }
        }
        return result.iterator();
    }
}
