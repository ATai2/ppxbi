package com.ppx.demo;

import com.ppx.demo.service.DictionaryService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.Hashtable;

public class Activator implements BundleActivator
{
    /**
     * Implements BundleActivator.start(). Registers an
     * instance of a dictionary service using the bundle context;
     * attaches properties to the service that can be queried
     * when performing a service look-up.
     * @param context the framework context for the bundle.
     **/
    @Override
    public void start(BundleContext context)
    {
        Hashtable<String, String> props = new Hashtable<String, String>();
        props.put("Language", "English");
        context.registerService(
                DictionaryService.class.getName(), new DictionaryImpl(), props);
    }

    /**
     * Implements BundleActivator.stop(). Does nothing since
     * the framework will automatically unregister any registered services.
     * @param context the framework context for the bundle.
     **/
    @Override
    public void stop(BundleContext context)
    {
        // NOTE: The service is automatically unregistered.
    }

    /**
     * A private inner class that implements a dictionary service;
     * see DictionaryService for details of the service.
     **/
    private static class DictionaryImpl implements DictionaryService
    {
        // The set of words contained in the dictionary.
        String[] m_dictionary =
                { "welcome", "to", "the", "osgi", "tutorial" };

        /**
         * Implements DictionaryService.checkWord(). Determines
         * if the passed in word is contained in the dictionary.
         * @param word the word to be checked.
         * @return true if the word is in the dictionary,
         *         false otherwise.
         **/
        @Override
        public boolean checkWord(String word)
        {
            word = word.toLowerCase();

            // This is very inefficient
            for (int i = 0; i < m_dictionary.length; i++)
            {
                if (m_dictionary[i].equals(word))
                {
                    return true;
                }
            }
            return false;
        }
    }
}