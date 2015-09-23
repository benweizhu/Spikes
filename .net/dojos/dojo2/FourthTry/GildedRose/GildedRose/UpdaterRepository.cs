﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GildedRose
{
    static class UpdatersRepository
    {
        private static readonly List<Updater> _updaters = new List<Updater>()
        {
            new UpdateSuddenDropItemStrategy(),
            new ValueAddingUpdater(),
            new NormalUpdater()
        };

        public static Updater TryGetUpdater(Item item)
        {
            return _updaters.FirstOrDefault(updater => updater.CanUpdate(item));
        }
    }
}
